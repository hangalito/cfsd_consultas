package consultas.dao;

import consultas.dbconexao.DatabaseConnection;
import consultas.modelo.Inscricao;
import jakarta.ejb.Stateless;

import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class InscricaoDao implements Serializable {
    private static final Logger LOG = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    private static void populateFields(Inscricao inscricao, ResultSet rs) throws SQLException {
        inscricao.setCodigo(rs.getInt("CodigoDaInscricao"));
        inscricao.setData(rs.getDate("DataDaInscricao").toLocalDate());
        new AlunoDao().findById(rs.getInt("CodigoDoAluno"))
                .ifPresent(inscricao::setAluno);
        new FuncionarioDao().findById(rs.getInt("CodigoDoFuncionario"))
                .ifPresent(inscricao::setFuncionario);
    }

    public List<Inscricao> findAll() {
        List<Inscricao> inscricoes = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM TblInscricoes")) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Inscricao insc = new Inscricao();
                        populateFields(insc, rs);
                        inscricoes.add(insc);
                    }
                }
            }
        } catch (SQLException ex) {
            String msg = ex.getLocalizedMessage();
            LOG.severe("Erro ao obter todas as inscrições: " + msg);
        }
        return inscricoes;
    }

    public List<Inscricao> findBetweenDates(LocalDate start, LocalDate end) {
        List<Inscricao> inscricoes = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM TblInscricoes WHERE DataDaInscricao BETWEEN ? AND ?")) {
                ps.setDate(1, Date.valueOf(start));
                ps.setDate(2, Date.valueOf(end));
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Inscricao insc = new Inscricao();
                        populateFields(insc, rs);
                        inscricoes.add(insc);
                    }
                }
            }
        } catch (SQLException ex) {
            String msg = ex.getLocalizedMessage();
            LOG.severe("Erro ao obter inscrições entre datas: " + msg);
        }
        return inscricoes;
    }
}
