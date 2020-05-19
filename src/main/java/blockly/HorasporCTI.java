package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class HorasporCTI {

public static final int TIMEOUT = 300;

/**
 *
 * @param Entidade
 * @return Var
 */
// HorasporCTI
public static Var ExecutarHorasporCTI(Var Entidade) throws Exception {
 return new Callable<Var>() {

   private Var CTI_A_B_e_D = Var.VAR_NULL;
   private Var ListaCTI = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    CTI_A_B_e_D = cronapi.database.Operations.query(Var.valueOf("app.entity.Agenda"),Var.valueOf("select a.medico.nome_med, SUM(a.horario_Escala.qt_horas_hre) from Agenda a where a.local_Plantao.nm_local_lpl <> \'CTI C\' group by a.medico.nome_med  order by a.medico.nome_med asc"));
    ListaCTI = cronapi.list.Operations.newList();
    while (cronapi.database.Operations.hasElement(CTI_A_B_e_D).getObjectAsBoolean()) {
        for (Iterator it_i = CTI_A_B_e_D.iterator(); it_i.hasNext();) {
            i = Var.valueOf(it_i.next());
            item = cronapi.map.Operations.createObjectMapWith(Var.valueOf("Medico",cronapi.list.Operations.get((cronapi.json.Operations.toList(i)), Var.valueOf(1))) , Var.valueOf("CTI A,B e D",cronapi.list.Operations.get((cronapi.json.Operations.toList(i)), Var.valueOf(2))));
            cronapi.list.Operations.addLast(ListaCTI,item);
            cronapi.database.Operations.next(CTI_A_B_e_D);
        } // end for
    } // end while
    return ListaCTI;
   }
 }.call();
}

}

