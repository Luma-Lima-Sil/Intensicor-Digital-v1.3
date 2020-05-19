package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.lang.Math;
import java.util.Iterator;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class TranferirPlantoes {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// TranferirPlantoes
public static Var trabsferirPlantoes() throws Exception {
 return new Callable<Var>() {

   private Var listaAgendas = Var.VAR_NULL;
   private Var agendaIterator = Var.VAR_NULL;

   public Var call() throws Exception {
    listaAgendas = cronapi.database.Operations.query(Var.valueOf("app.entity.Agenda"),Var.valueOf("select a from Agenda a where a.medico.id = :medicoId AND a.horario_Escala.id = :horario_EscalaId AND a.local_Plantao.id = :local_PlantaoId AND a.startsAt >= :startsAt"),Var.valueOf("medicoId",cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.medico"))),Var.valueOf("horario_EscalaId",cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.horarioEscala"))),Var.valueOf("local_PlantaoId",cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.localPlantao"))),Var.valueOf("startsAt",cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dataTransPlantao"))));
    if (cronapi.database.Operations.hasElement(listaAgendas).getObjectAsBoolean()) {
        for (Iterator it_agendaIterator = listaAgendas.iterator(); it_agendaIterator.hasNext();) {
            agendaIterator = Var.valueOf(it_agendaIterator.next());
            if (Var.valueOf(Var.valueOf(Var.valueOf(RetornaCorSemana(cronapi.json.Operations.getJsonOrMapField(agendaIterator, Var.valueOf("startsAt")))).equals(cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.corSemana")))).getObjectAsBoolean() && Var.valueOf(cronapi.dateTime.Operations.getDayOfWeek(cronapi.json.Operations.getJsonOrMapField(agendaIterator, Var.valueOf("startsAt"))).equals(cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.diaSemana")))).getObjectAsBoolean()).getObjectAsBoolean()) {
                cronapi.database.Operations.execute(Var.valueOf("app.entity.Agenda"), Var.valueOf("update Agenda set medico = :medico where id = :id"),Var.valueOf("medico",cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.medicoDestino"))),Var.valueOf("id",cronapi.json.Operations.getJsonOrMapField(agendaIterator, Var.valueOf("id"))));
            }
        } // end for
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"), Var.valueOf("Transferência realizada com sucesso!"));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeView"), Var.valueOf("#/home/logged/home"));
    } else {
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("info"), Var.valueOf("Nenhuma agenda encontrada com os filtros específicados!"));
    }
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param param_DataVerificar
 * @return Var
 */
// Descreva esta função...
public static Var RetornaCorSemana(Var param_DataVerificar) throws Exception {
 return new Callable<Var>() {

   // param
   private Var DataVerificar = param_DataVerificar;
   // end
   private Var dataReferencia = Var.VAR_NULL;
   private Var DifDiasDatas = Var.VAR_NULL;
   private Var NumeroSemanas = Var.VAR_NULL;
   private Var cor = Var.VAR_NULL;

   public Var call() throws Exception {
    dataReferencia = cronapi.dateTime.Operations.newDate(Var.valueOf(2018), Var.valueOf(1), Var.valueOf(1), Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL);
    DataVerificar = cronapi.dateTime.Operations.newDate(cronapi.dateTime.Operations.getYear(DataVerificar), cronapi.dateTime.Operations.getMonth(DataVerificar), cronapi.dateTime.Operations.getDay(DataVerificar), Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL);
    DifDiasDatas = cronapi.dateTime.Operations.getDaysBetweenDates(DataVerificar, dataReferencia);
    NumeroSemanas = cronapi.math.Operations.floor(cronapi.math.Operations.divisor(DifDiasDatas,Var.valueOf(7)));
    cor = cronapi.math.Operations.mod(NumeroSemanas, Var.valueOf(4));
    cor = cronapi.math.Operations.sum(cor,Var.valueOf(1));
    if (Var.valueOf(cor.equals(Var.valueOf(0))).getObjectAsBoolean()) {
        cor = Var.valueOf(4);
    }
    return cor;
   }
 }.call();
}

}

