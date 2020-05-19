package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;
import org.springframework.data.domain.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;


/** 
* 
* RestController @generated 
* 
*/ 

@RestController
@RequestMapping(value = "/api/rest/main/BuscarDados")

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class BuscarDados {

public static final int TIMEOUT = 300;

/**
 *
 * @param month
 * @param year
 * @return Var
 */

@RequestMapping(method = RequestMethod.GET, value="/ExecutarBuscarDados/{month}/{year}")
// BuscarDados
public static Var ExecutarBuscarDados(@PathVariable("month") Var month ,@PathVariable("year") Var year ) throws Exception {
 return new Callable<Var>() {

   private Var consul = Var.VAR_NULL;
   private Var listaDadosCalendario = Var.VAR_NULL;
   private Var userID = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var titulo = Var.VAR_NULL;
   private Var itemLista = Var.VAR_NULL;

   public Var call() throws Exception {
    consul = cronapi.database.Operations.queryPaged(Var.valueOf("app.entity.Plantao"),Var.valueOf("select a.medico.user.name, a.horario_Escala.nm_horario_hre, a.local_Plantao.hospitais.nm_hospital_hsp, a.local_Plantao.nm_local_lpl, a.responsible, a.color, a.startsAt, a.endsAt, a.draggable, a.resizable, a.actions, a.id, a.medico.id, a.horario_Escala.nm_horario_hre, a.horario_Escala.id from Agenda a where EXTRACT(YEAR FROM a.startsAt) = :ano order by a.medico.user.name, a.dt_agenda_age desc"),Var.valueOf(true),Var.valueOf("ano",year));
    listaDadosCalendario = cronapi.list.Operations.newList();
    userID = cronapi.list.Operations.getFirst((cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select u.id from User u where u.login = :login"),Var.valueOf("login",cronapi.util.Operations.getCurrentUserName()))));
    userID = cronapi.list.Operations.getFirst((cronapi.database.Operations.query(Var.valueOf("app.entity.Medico"),Var.valueOf("select m.id from Medico m where m.user.id = :userId"),Var.valueOf("userId",userID))));
    while (cronapi.database.Operations.hasElement(consul).getObjectAsBoolean()) {
        for (Iterator it_i = consul.iterator(); it_i.hasNext();) {
            i = Var.valueOf(it_i.next());
            if (Var.valueOf(Var.valueOf(cronapi.dateTime.Operations.getYear(cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(7))).equals(year)).getObjectAsBoolean() && Var.valueOf(cronapi.dateTime.Operations.getMonth(cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(7))).equals(month)).getObjectAsBoolean()).getObjectAsBoolean()) {
                titulo = Var.valueOf(cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(1)).toString() + cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(2)).toString() + cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(3)).toString() + cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(4)).toString());
                if (Var.valueOf(cronapi.dateTime.Operations.newDate(cronapi.dateTime.Operations.getYear(cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(7))), cronapi.dateTime.Operations.getMonth(cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(7))), cronapi.dateTime.Operations.getDay(cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(7))), Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL).equals(cronapi.dateTime.Operations.newDate(Var.valueOf(2020), Var.valueOf(12), Var.valueOf(20), Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL))).getObjectAsBoolean()) {
                  {}
                }
                itemLista = cronapi.map.Operations.createObjectMapWith(Var.valueOf("title",titulo) , Var.valueOf("medico",cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(1))) , Var.valueOf("responsavel",cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(5))) , Var.valueOf("local",cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(4))) , Var.valueOf("color",cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(6))) , Var.valueOf("startsAt",cronapi.dateTime.Operations.newDate(cronapi.dateTime.Operations.getYear(cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(7))), cronapi.dateTime.Operations.getMonth(cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(7))), cronapi.dateTime.Operations.getDay(cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(7))), Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL)) , Var.valueOf("endsAt",cronapi.dateTime.Operations.newDate(cronapi.dateTime.Operations.getYear(cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(8))), cronapi.dateTime.Operations.getMonth(cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(8))), cronapi.dateTime.Operations.getDay(cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(8))), Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL)) , Var.valueOf("draggable",cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(9))) , Var.valueOf("resizable",cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(10))) , Var.valueOf("actions",cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(11))) , Var.valueOf("medicoId",userID) , Var.valueOf("agendaId",cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(12))) , Var.valueOf("agendaMedicoId",cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(13))) , Var.valueOf("horarioEscala",cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(14))) , Var.valueOf("horarioEscalaId",cronapi.list.Operations.get((cronapi.json.Operations.toJson(i)), Var.valueOf(15))));
                cronapi.list.Operations.addLast(listaDadosCalendario,itemLista);
            }
            cronapi.database.Operations.next(consul);
        } // end for
    } // end while
    return listaDadosCalendario;
   }
 }.call();
}

/**
 */

@RequestMapping(method = RequestMethod.GET, value="/fa_C3_A7a_algo")
// Descreva esta função...
public static void fa_C3_A7a_algo() throws Exception {
  new Callable<Var>() {

   private Var teste = Var.VAR_NULL;

   public Var call() throws Exception {
    teste = cronapi.dateTime.Operations.getMonth(cronapi.dateTime.Operations.formatDateTime(cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.data")), Var.valueOf("dd/MM/yyyy")));
    System.out.println(teste.getObjectAsString());
   return Var.VAR_NULL;
   }
 }.call();
}

}

