package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class EditarAgenda {

public static final int TIMEOUT = 300;

/**
 *
 * @param entidade
 * @return Var
 */
// EditarAgenda
public static Var EditarAgendaRetroativa(Var entidade) throws Exception {
 return new Callable<Var>() {

   private Var dataTratada = Var.VAR_NULL;

   public Var call() throws Exception {
    dataTratada = cronapi.dateTime.Operations.incMonth(cronapi.dateTime.Operations.getNowNoHour(), Var.valueOf(-2));
    System.out.println(Var.valueOf(Var.valueOf("Agenda: ").toString() + entidade.toString()).getObjectAsString());
    if (Var.valueOf(cronapi.object.Operations.getObjectField(entidade, Var.valueOf("startsAt")).compareTo(dataTratada) <= 0).getObjectAsBoolean()) {
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.refreshDatasource"), Var.valueOf("ObterDadosAgenda"), Var.valueOf("true"));
        cronapi.util.Operations.throwException(cronapi.util.Operations.createException(Var.valueOf(Var.valueOf("Não foi possível editar a agenda do dia ").toString() + cronapi.dateTime.Operations.formatDateTime(cronapi.object.Operations.getObjectField(entidade, Var.valueOf("startsAt")), Var.valueOf("dd/MM/yyyy")).toString() + Var.valueOf(". Data máxima de edição retroativo é de até dois meses!").toString())));
    }
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @return Var
 */
// EditarAgenda
public static Var SalvarAgendaRetroativa() throws Exception {
 return new Callable<Var>() {

   private Var dataTratada = Var.VAR_NULL;

   public Var call() throws Exception {
    dataTratada = cronapi.dateTime.Operations.incMonth(cronapi.dateTime.Operations.getNowNoHour(), Var.valueOf(-2));
    if ((Var.valueOf(cronapi.dateTime.Operations.getDaysBetweenDates(cronapi.dateTime.Operations.getNow(), cronapi.dateTime.Operations.formatDateTime(cronapi.screen.Operations.getValueOfField(Var.valueOf("ObterDadosAgenda.active.startsAt")), Var.valueOf("dd/MM/yyyy"))).compareTo(Var.valueOf(61)) > 0)).negate().getObjectAsBoolean()) {
        cronapi.database.Operations.execute(Var.valueOf("app.entity.Agenda"), Var.valueOf("update Agenda set medico = :medico, horario_Escala = :horario_Escala, local_Plantao = :local_Plantao where id = :id"),Var.valueOf("medico",cronapi.screen.Operations.getValueOfField(Var.valueOf("ObterDadosAgenda.active.medico_id"))),Var.valueOf("horario_Escala",cronapi.screen.Operations.getValueOfField(Var.valueOf("ObterDadosAgenda.active.horario_Escala_id"))),Var.valueOf("local_Plantao",cronapi.screen.Operations.getValueOfField(Var.valueOf("ObterDadosAgenda.active.local_Plantao_id"))),Var.valueOf("id",cronapi.screen.Operations.getValueOfField(Var.valueOf("ObterDadosAgenda.active.id"))));
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"), Var.valueOf("Agenda Atualizada!"));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.refreshDatasource"), Var.valueOf("ObterDadosAgenda"), Var.valueOf("true"));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.hideModal"), Var.valueOf("modal77303"));
    } else {
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), Var.valueOf(Var.valueOf("Não foi possível editar a agenda do dia ").toString() + cronapi.dateTime.Operations.formatDateTime(cronapi.screen.Operations.getValueOfField(Var.valueOf("ObterDadosAgenda.active.startsAt")), Var.valueOf("dd/MM/yyyy")).toString() + Var.valueOf(". Data máxima de edição retroativo é de até dois meses!").toString()));
    }
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 */
// Descreva esta função...
public static void FecharModal() throws Exception {
  new Callable<Var>() {

   public Var call() throws Exception {
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.hideModal"), Var.valueOf("modal77303"));
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 */
// Descreva esta função...
public static void RetornarMedicoAtual() throws Exception {
  new Callable<Var>() {

   private Var idMedico = Var.VAR_NULL;

   public Var call() throws Exception {
    idMedico = cronapi.database.Operations.query(Var.valueOf("app.entity.Agenda"),Var.valueOf("select a.medico.id from Agenda a where a.id = :id"),Var.valueOf("id",cronapi.screen.Operations.getValueOfField(Var.valueOf("Agenda.active.id"))));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"), Var.valueOf("Agenda.active.medicoAnterior"), cronapi.list.Operations.get(idMedico, Var.valueOf(1)));
   return Var.VAR_NULL;
   }
 }.call();
}

}

