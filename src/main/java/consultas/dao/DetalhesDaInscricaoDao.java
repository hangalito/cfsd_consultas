package consultas.dao;

import consultas.dbconexao.DatabaseConnection;
import consultas.modelo.DetalhesDaInscricao;
import consultas.modelo.Inscricao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DetalhesDaInscricaoDao {
    private static final Logger LOG = Logger.getLogger(DetalhesDaInscricaoDao.class.getName());


    public List<DetalhesDaInscricao> findByInsc(Inscricao insc) {
        List<DetalhesDaInscricao> details = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM TblDetalhesDaInscricao WHERE CodigoDaInscricao = ?")) {
                ps.setInt(1, insc.getCodigo());
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        DetalhesDaInscricao detail = new DetalhesDaInscricao();
                        detail.setDataDeInicio(rs.getTimestamp("DataDeInicio").toLocalDateTime());
                        detail.setDataDeFim(rs.getTimestamp("DataDeFim").toLocalDateTime());
                        detail.setValorPago(rs.getDouble("ValorPago"));
                        detail.setValorPago2(rs.getDouble("ValorPago2"));
                        detail.setObs(rs.getString("Observacoes"));
                        detail.setNotaFinal(rs.getInt("NotaFinal"));

                        new CursoDao().selectById(rs.getString("CodigoDoCurso"))
                                .ifPresent(detail::setCurso);
                        new TurmaDao().findById(rs.getString("CodigoDaTurma"))
                                .ifPresent(detail::setTurma);
                        new HorarioDao().findById(rs.getString("CodigoDoHorario"))
                                .ifPresent(detail::setHorario);
                        new FuncionarioDao().findById(rs.getInt("CodigoDoProfessor"))
                                .ifPresent(detail::setProfessor);
                        details.add(detail);
                    }
                }
            }
        } catch (SQLException ex) {
            String msg = ex.getLocalizedMessage();
            LOG.log(Level.SEVERE, ex, () -> "Erro ao obter detalhes: " + msg);
        }
        return details;
    }
}
