package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.lang.Math;
import java.util.Iterator;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class ProrrogacaoAgenda {

public static final int TIMEOUT = 3000;

/**
 *
 * @param Data
 * @param Medico
 * @param LocalPlantao
 * @param HorarioEscala
 * @param Semana
 * @param CorSemana
 * @return Var
 */
// Descreva esta função...
public static Var ExisteAgendaMedico(Var Data, Var Medico, Var LocalPlantao, Var HorarioEscala, Var Semana, Var CorSemana) throws Exception {
 return new Callable<Var>() {

   private Var AchouAgenda = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;

   public Var call() throws Exception {
    AchouAgenda = Var.VAR_FALSE;
    for (Iterator it_i = cronapi.database.Operations.query(Var.valueOf("app.entity.Agenda"),Var.valueOf("select a from Agenda a where a.startsAt = :startsAt AND a.horario_Escala.id = :horario_EscalaId AND a.local_Plantao.id = :local_PlantaoId"),Var.valueOf("startsAt",Data),Var.valueOf("horario_EscalaId",HorarioEscala),Var.valueOf("local_PlantaoId",LocalPlantao)).iterator(); it_i.hasNext();) {
        i = Var.valueOf(it_i.next());
        if (Var.valueOf(Var.valueOf(Var.valueOf(RetornaCorSemana(Data)).equals(CorSemana)).getObjectAsBoolean() && Var.valueOf(cronapi.dateTime.Operations.getDayOfWeek(Data).equals(Semana)).getObjectAsBoolean()).getObjectAsBoolean()) {
            AchouAgenda = Var.VAR_TRUE;
            System.out.println(Var.valueOf("Achou Agenda").getObjectAsString());
        }
    } // end for
    return AchouAgenda;
   }
 }.call();
}

/**
 */
// Descreva esta função...
public static void Finalizar() throws Exception {
  new Callable<Var>() {

   private Var lista_SegundaVermelho = Var.VAR_NULL;
   private Var lista_TercaVermelho = Var.VAR_NULL;
   private Var lista_QuartaVermelho = Var.VAR_NULL;
   private Var lista_QuintaVermelho = Var.VAR_NULL;
   private Var lista_SextaVermelho = Var.VAR_NULL;
   private Var lista_SabadoVermelho = Var.VAR_NULL;
   private Var lista_DomingoVermelho = Var.VAR_NULL;
   private Var lista_SegundaVerde = Var.VAR_NULL;
   private Var lista_TercaVerde = Var.VAR_NULL;
   private Var lista_QuartaVerde = Var.VAR_NULL;
   private Var lista_QuintaVerde = Var.VAR_NULL;
   private Var lista_SextaVerde = Var.VAR_NULL;
   private Var lista_SabadoVerde = Var.VAR_NULL;
   private Var lista_DomingoVerde = Var.VAR_NULL;
   private Var lista_SegundaCinza = Var.VAR_NULL;
   private Var lista_TercaCinza = Var.VAR_NULL;
   private Var lista_QuartaCinza = Var.VAR_NULL;
   private Var lista_QuintaCinza = Var.VAR_NULL;
   private Var lista_SextaCinza = Var.VAR_NULL;
   private Var lista_SabadoCinza = Var.VAR_NULL;
   private Var lista_DomingoCinza = Var.VAR_NULL;
   private Var lista_SegundaAzul = Var.VAR_NULL;
   private Var lista_TercaAzul = Var.VAR_NULL;
   private Var lista_QuartaAzul = Var.VAR_NULL;
   private Var lista_QuintaAzul = Var.VAR_NULL;
   private Var lista_SextaAzul = Var.VAR_NULL;
   private Var lista_SabadoAzul = Var.VAR_NULL;
   private Var lista_DomingoAzul = Var.VAR_NULL;
   private Var DataInicial = Var.VAR_NULL;
   private Var DataFinal = Var.VAR_NULL;
   private Var diaSemana = Var.VAR_NULL;
   private Var listaAgendas = Var.VAR_NULL;
   private Var agenda = Var.VAR_NULL;
   private Var listaAtual = Var.VAR_NULL;

   public Var call() throws Exception {
    if (cronapi.logic.Operations.isNullOrEmpty(cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.mesReferencia"))).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(cronapi.util.Operations.createException(Var.valueOf("Selecione o mês de referência!")));
    }
    if (cronapi.logic.Operations.isNullOrEmpty(cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dataInicial"))).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(cronapi.util.Operations.createException(Var.valueOf("Selecione a data inicial!")));
    }
    if (cronapi.logic.Operations.isNullOrEmpty(cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dataFinal"))).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(cronapi.util.Operations.createException(Var.valueOf("Selecione a data final!")));
    }
    lista_SegundaVermelho = cronapi.list.Operations.newList();
    lista_TercaVermelho = cronapi.list.Operations.newList();
    lista_QuartaVermelho = cronapi.list.Operations.newList();
    lista_QuintaVermelho = cronapi.list.Operations.newList();
    lista_SextaVermelho = cronapi.list.Operations.newList();
    lista_SabadoVermelho = cronapi.list.Operations.newList();
    lista_DomingoVermelho = cronapi.list.Operations.newList();
    lista_SegundaVerde = cronapi.list.Operations.newList();
    lista_TercaVerde = cronapi.list.Operations.newList();
    lista_QuartaVerde = cronapi.list.Operations.newList();
    lista_QuintaVerde = cronapi.list.Operations.newList();
    lista_SextaVerde = cronapi.list.Operations.newList();
    lista_SabadoVerde = cronapi.list.Operations.newList();
    lista_DomingoVerde = cronapi.list.Operations.newList();
    lista_SegundaCinza = cronapi.list.Operations.newList();
    lista_TercaCinza = cronapi.list.Operations.newList();
    lista_QuartaCinza = cronapi.list.Operations.newList();
    lista_QuintaCinza = cronapi.list.Operations.newList();
    lista_SextaCinza = cronapi.list.Operations.newList();
    lista_SabadoCinza = cronapi.list.Operations.newList();
    lista_DomingoCinza = cronapi.list.Operations.newList();
    lista_SegundaAzul = cronapi.list.Operations.newList();
    lista_TercaAzul = cronapi.list.Operations.newList();
    lista_QuartaAzul = cronapi.list.Operations.newList();
    lista_QuintaAzul = cronapi.list.Operations.newList();
    lista_SextaAzul = cronapi.list.Operations.newList();
    lista_SabadoAzul = cronapi.list.Operations.newList();
    lista_DomingoAzul = cronapi.list.Operations.newList();
    DataInicial = cronapi.dateTime.Operations.newDate(cronapi.dateTime.Operations.getYear(cronapi.dateTime.Operations.getNow()), cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.mesReferencia")), Var.valueOf(1), Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL);
    DataFinal = cronapi.dateTime.Operations.newDate(cronapi.dateTime.Operations.getYear(cronapi.dateTime.Operations.getNow()), cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.mesReferencia")), cronapi.dateTime.Operations.getLastDayFromMonth(cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.mesReferencia")), cronapi.dateTime.Operations.getYear(cronapi.dateTime.Operations.getNow())), Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL);
    while (!(Var.valueOf(DataInicial.compareTo(DataFinal) > 0)).getObjectAsBoolean()) {
        diaSemana = cronapi.dateTime.Operations.getDayOfWeek(DataInicial);
        listaAgendas = cronapi.database.Operations.query(Var.valueOf("app.entity.Agenda"),Var.valueOf("select a from Agenda a where a.startsAt = :startsAt"),Var.valueOf("startsAt",DataInicial));
        if (cronapi.database.Operations.hasElement(listaAgendas).getObjectAsBoolean()) {
            for (Iterator it_agenda = listaAgendas.iterator(); it_agenda.hasNext();) {
                agenda = Var.valueOf(it_agenda.next());
                if (Var.valueOf(Var.valueOf(RetornaCorSemana(DataInicial)).equals(Var.valueOf(1))).getObjectAsBoolean()) {
                    if (Var.valueOf(diaSemana.equals(Var.valueOf(1))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_DomingoVermelho,agenda);
                    } else if (Var.valueOf(diaSemana.equals(Var.valueOf(2))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_SegundaVermelho,agenda);
                    } else if (Var.valueOf(diaSemana.equals(Var.valueOf(3))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_TercaVermelho,agenda);
                    } else if (Var.valueOf(diaSemana.equals(Var.valueOf(4))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_QuartaVermelho,agenda);
                    } else if (Var.valueOf(diaSemana.equals(Var.valueOf(5))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_QuintaVermelho,agenda);
                    } else if (Var.valueOf(diaSemana.equals(Var.valueOf(6))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_SextaVermelho,agenda);
                    } else if (Var.valueOf(diaSemana.equals(Var.valueOf(7))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_SabadoVermelho,agenda);
                    }
                } else if (Var.valueOf(Var.valueOf(RetornaCorSemana(DataInicial)).equals(Var.valueOf(2))).getObjectAsBoolean()) {
                    if (Var.valueOf(diaSemana.equals(Var.valueOf(1))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_DomingoVerde,agenda);
                    } else if (Var.valueOf(diaSemana.equals(Var.valueOf(2))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_SegundaVerde,agenda);
                    } else if (Var.valueOf(diaSemana.equals(Var.valueOf(3))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_TercaVerde,agenda);
                    } else if (Var.valueOf(diaSemana.equals(Var.valueOf(4))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_QuartaVerde,agenda);
                    } else if (Var.valueOf(diaSemana.equals(Var.valueOf(5))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_QuintaVerde,agenda);
                    } else if (Var.valueOf(diaSemana.equals(Var.valueOf(6))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_SextaVerde,agenda);
                    } else if (Var.valueOf(diaSemana.equals(Var.valueOf(7))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_SabadoVerde,agenda);
                    }
                } else if (Var.valueOf(Var.valueOf(RetornaCorSemana(DataInicial)).equals(Var.valueOf(3))).getObjectAsBoolean()) {
                    if (Var.valueOf(diaSemana.equals(Var.valueOf(1))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_DomingoCinza,agenda);
                    } else if (Var.valueOf(diaSemana.equals(Var.valueOf(2))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_SegundaCinza,agenda);
                    } else if (Var.valueOf(diaSemana.equals(Var.valueOf(3))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_TercaCinza,agenda);
                    } else if (Var.valueOf(diaSemana.equals(Var.valueOf(4))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_QuartaCinza,agenda);
                    } else if (Var.valueOf(diaSemana.equals(Var.valueOf(5))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_QuintaCinza,agenda);
                    } else if (Var.valueOf(diaSemana.equals(Var.valueOf(6))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_SextaCinza,agenda);
                    } else if (Var.valueOf(diaSemana.equals(Var.valueOf(7))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_SabadoCinza,agenda);
                    }
                } else if (Var.valueOf(Var.valueOf(RetornaCorSemana(DataInicial)).equals(Var.valueOf(0))).getObjectAsBoolean()) {
                    if (Var.valueOf(diaSemana.equals(Var.valueOf(1))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_DomingoAzul,agenda);
                    } else if (Var.valueOf(diaSemana.equals(Var.valueOf(2))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_SegundaAzul,agenda);
                    } else if (Var.valueOf(diaSemana.equals(Var.valueOf(3))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_TercaAzul,agenda);
                    } else if (Var.valueOf(diaSemana.equals(Var.valueOf(4))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_QuartaAzul,agenda);
                    } else if (Var.valueOf(diaSemana.equals(Var.valueOf(5))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_QuintaAzul,agenda);
                    } else if (Var.valueOf(diaSemana.equals(Var.valueOf(6))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_SextaAzul,agenda);
                    } else if (Var.valueOf(diaSemana.equals(Var.valueOf(7))).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(lista_SabadoAzul,agenda);
                    }
                }
            } // end for
        }
        DataInicial = cronapi.dateTime.Operations.incDay(DataInicial, Var.valueOf(1));
    } // end while
    DataInicial = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dataInicial"));
    DataFinal = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dataFinal"));
    while (!(Var.valueOf(DataInicial.compareTo(DataFinal) > 0)).getObjectAsBoolean()) {
        diaSemana = cronapi.dateTime.Operations.getDayOfWeek(DataInicial);
        if (Var.valueOf(Var.valueOf(RetornaCorSemana(DataInicial)).equals(Var.valueOf(1))).getObjectAsBoolean()) {
            if (Var.valueOf(diaSemana.equals(Var.valueOf(1))).getObjectAsBoolean()) {
                listaAtual = lista_DomingoVermelho;
            } else if (Var.valueOf(diaSemana.equals(Var.valueOf(2))).getObjectAsBoolean()) {
                listaAtual = lista_SegundaVermelho;
            } else if (Var.valueOf(diaSemana.equals(Var.valueOf(3))).getObjectAsBoolean()) {
                listaAtual = lista_TercaVermelho;
            } else if (Var.valueOf(diaSemana.equals(Var.valueOf(4))).getObjectAsBoolean()) {
                listaAtual = lista_QuartaVermelho;
            } else if (Var.valueOf(diaSemana.equals(Var.valueOf(5))).getObjectAsBoolean()) {
                listaAtual = lista_QuintaVermelho;
            } else if (Var.valueOf(diaSemana.equals(Var.valueOf(6))).getObjectAsBoolean()) {
                listaAtual = lista_SextaVermelho;
            } else if (Var.valueOf(diaSemana.equals(Var.valueOf(7))).getObjectAsBoolean()) {
                listaAtual = lista_SabadoVermelho;
            }
        } else if (Var.valueOf(Var.valueOf(RetornaCorSemana(DataInicial)).equals(Var.valueOf(2))).getObjectAsBoolean()) {
            if (Var.valueOf(diaSemana.equals(Var.valueOf(1))).getObjectAsBoolean()) {
                listaAtual = lista_DomingoVerde;
            } else if (Var.valueOf(diaSemana.equals(Var.valueOf(2))).getObjectAsBoolean()) {
                listaAtual = lista_SegundaVerde;
            } else if (Var.valueOf(diaSemana.equals(Var.valueOf(3))).getObjectAsBoolean()) {
                listaAtual = lista_TercaVerde;
            } else if (Var.valueOf(diaSemana.equals(Var.valueOf(4))).getObjectAsBoolean()) {
                listaAtual = lista_QuartaVerde;
            } else if (Var.valueOf(diaSemana.equals(Var.valueOf(5))).getObjectAsBoolean()) {
                listaAtual = lista_QuintaVerde;
            } else if (Var.valueOf(diaSemana.equals(Var.valueOf(6))).getObjectAsBoolean()) {
                listaAtual = lista_SextaVerde;
            } else if (Var.valueOf(diaSemana.equals(Var.valueOf(7))).getObjectAsBoolean()) {
                listaAtual = lista_SabadoVerde;
            }
        } else if (Var.valueOf(Var.valueOf(RetornaCorSemana(DataInicial)).equals(Var.valueOf(3))).getObjectAsBoolean()) {
            if (Var.valueOf(diaSemana.equals(Var.valueOf(1))).getObjectAsBoolean()) {
                listaAtual = lista_DomingoCinza;
            } else if (Var.valueOf(diaSemana.equals(Var.valueOf(2))).getObjectAsBoolean()) {
                listaAtual = lista_SegundaCinza;
            } else if (Var.valueOf(diaSemana.equals(Var.valueOf(3))).getObjectAsBoolean()) {
                listaAtual = lista_TercaCinza;
            } else if (Var.valueOf(diaSemana.equals(Var.valueOf(4))).getObjectAsBoolean()) {
                listaAtual = lista_QuartaCinza;
            } else if (Var.valueOf(diaSemana.equals(Var.valueOf(5))).getObjectAsBoolean()) {
                listaAtual = lista_QuintaCinza;
            } else if (Var.valueOf(diaSemana.equals(Var.valueOf(6))).getObjectAsBoolean()) {
                listaAtual = lista_SextaCinza;
            } else if (Var.valueOf(diaSemana.equals(Var.valueOf(7))).getObjectAsBoolean()) {
                listaAtual = lista_SabadoCinza;
            }
        } else if (Var.valueOf(Var.valueOf(RetornaCorSemana(DataInicial)).equals(Var.valueOf(0))).getObjectAsBoolean()) {
            if (Var.valueOf(diaSemana.equals(Var.valueOf(1))).getObjectAsBoolean()) {
                listaAtual = lista_DomingoAzul;
            } else if (Var.valueOf(diaSemana.equals(Var.valueOf(2))).getObjectAsBoolean()) {
                listaAtual = lista_SegundaAzul;
            } else if (Var.valueOf(diaSemana.equals(Var.valueOf(3))).getObjectAsBoolean()) {
                listaAtual = lista_TercaAzul;
            } else if (Var.valueOf(diaSemana.equals(Var.valueOf(4))).getObjectAsBoolean()) {
                listaAtual = lista_QuartaAzul;
            } else if (Var.valueOf(diaSemana.equals(Var.valueOf(5))).getObjectAsBoolean()) {
                listaAtual = lista_QuintaAzul;
            } else if (Var.valueOf(diaSemana.equals(Var.valueOf(6))).getObjectAsBoolean()) {
                listaAtual = lista_SextaAzul;
            } else if (Var.valueOf(diaSemana.equals(Var.valueOf(7))).getObjectAsBoolean()) {
                listaAtual = lista_SabadoAzul;
            }
        }
        for (Iterator it_agenda = listaAtual.iterator(); it_agenda.hasNext();) {
            agenda = Var.valueOf(it_agenda.next());
            if (Var.valueOf(ExisteAgendaMedico(DataInicial, cronapi.json.Operations.getJsonOrMapField(agenda, Var.valueOf("medico.id")), cronapi.json.Operations.getJsonOrMapField(agenda, Var.valueOf("local_Plantao.id")), cronapi.json.Operations.getJsonOrMapField(agenda, Var.valueOf("horario_Escala.id")), diaSemana, Var.valueOf(RetornaCorSemana(DataInicial)))).negate().getObjectAsBoolean()) {
                System.out.println(Var.valueOf(DataInicial.toString() + Var.valueOf(" - ").toString() + cronapi.json.Operations.getJsonOrMapField(agenda, Var.valueOf("medico.id")).toString() + Var.valueOf(" - ").toString() + cronapi.json.Operations.getJsonOrMapField(agenda, Var.valueOf("horario_Escala.id")).toString() + Var.valueOf(" - ").toString() + cronapi.json.Operations.getJsonOrMapField(agenda, Var.valueOf("local_Plantao.id")).toString()).getObjectAsString());
                cronapi.database.Operations.insert(Var.valueOf("app.entity.Agenda"),Var.valueOf("diaSemana",diaSemana),Var.valueOf("medico",cronapi.json.Operations.getJsonOrMapField(agenda, Var.valueOf("medico.id"))),Var.valueOf("horario_Escala",cronapi.json.Operations.getJsonOrMapField(agenda, Var.valueOf("horario_Escala.id"))),Var.valueOf("startsAt",DataInicial),Var.valueOf("corSemana",Var.valueOf(RetornaCorSemana(DataInicial))),Var.valueOf("local_Plantao",cronapi.json.Operations.getJsonOrMapField(agenda, Var.valueOf("local_Plantao.id"))),Var.valueOf("endsAt",DataInicial),Var.valueOf("dt_agenda_age",DataInicial));
            }
        } // end for
        DataInicial = cronapi.dateTime.Operations.incDay(DataInicial, Var.valueOf(1));
    } // end while
    cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"), Var.valueOf("Agenda prorrogada com sucesso!"));
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

   public Var call() throws Exception {
    dataReferencia = cronapi.dateTime.Operations.newDate(Var.valueOf(2018), Var.valueOf(1), Var.valueOf(1), Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL);
    DataVerificar = cronapi.dateTime.Operations.newDate(cronapi.dateTime.Operations.getYear(DataVerificar), cronapi.dateTime.Operations.getMonth(DataVerificar), cronapi.dateTime.Operations.getDay(DataVerificar), Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL);
    DifDiasDatas = cronapi.dateTime.Operations.getDaysBetweenDates(DataVerificar, dataReferencia);
    NumeroSemanas = cronapi.math.Operations.floor(cronapi.math.Operations.divisor(DifDiasDatas,Var.valueOf(7)));
    return cronapi.math.Operations.mod(NumeroSemanas, Var.valueOf(4));
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var VerificaExibirProrrogacao() throws Exception {
 return new Callable<Var>() {

   private Var dataReferencia = Var.VAR_NULL;
   private Var DataVerificar = Var.VAR_NULL;
   private Var DifDiasDatas = Var.VAR_NULL;
   private Var NumeroSemanas = Var.VAR_NULL;

   public Var call() throws Exception {
    return Var.valueOf(cronapi.database.Operations.hasElement(cronapi.database.Operations.query(Var.valueOf("app.entity.Role"),Var.valueOf("select r from Role r where r.user.login = :userLogin AND r.id = \'Administrators\'"),Var.valueOf("userLogin",cronapi.util.Operations.getCurrentUserName()))).getObjectAsBoolean() && Var.valueOf(cronapi.dateTime.Operations.getMonth(cronapi.dateTime.Operations.getNow()).compareTo(Var.valueOf(11)) >= 0).getObjectAsBoolean());
   }
 }.call();
}

}

