window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.EditarAgendas = window.blockly.js.blockly.EditarAgendas || {};

/**
 * EditarAgendas
 */
window.blockly.js.blockly.EditarAgendas.ObterMedicoAnterior = function() {
 var item;
  this.cronapi.screen.startEditingMode("Agenda");
  this.cronapi.screen.changeValueOfField("Agenda.active.medicoAnterior", this.cronapi.screen.getValueOfField("Agenda.active.medico"));
}
