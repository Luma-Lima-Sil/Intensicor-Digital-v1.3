package app.dao;

import app.entity.*;
import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.*;
import org.springframework.transaction.annotation.*; 


/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * Os métodos de create, edit, delete e outros estão abstraídos no JpaRepository
 * 
 * @see org.springframework.data.jpa.repository.JpaRepository
 * 
 * @generated
 */
@Repository("DiaSemanaDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface DiaSemanaDAO extends JpaRepository<DiaSemana, java.lang.String> {

  /**
   * Obtém a instância de DiaSemana utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM DiaSemana entity WHERE entity.id = :id")
  public DiaSemana findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de DiaSemana utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM DiaSemana entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);


      
  /**
   * OneToMany Relation - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM Agenda entity WHERE entity.diaSemana.id = :id AND (:search = :search)")
  public Page<Agenda> findAgendaGeneralSearch(@Param(value="search") java.lang.String search, @Param(value="id") java.lang.String id, Pageable pageable);

  /** 
   * OneToMany Relation - Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM Agenda entity WHERE entity.diaSemana.id = :id AND (:dt_agenda_age is null OR entity.dt_agenda_age = :dt_agenda_age) AND (:cd_status_age is null OR entity.cd_status_age = :cd_status_age)")
  public Page<Agenda> findAgendaSpecificSearch(@Param(value="id") java.lang.String id, @Param(value="dt_agenda_age") java.util.Date dt_agenda_age, @Param(value="cd_status_age") java.lang.Integer cd_status_age, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Agenda entity WHERE entity.diaSemana.id = :id")
  public Page<Agenda> findAgenda(@Param(value="id") java.lang.String id, Pageable pageable);

}
