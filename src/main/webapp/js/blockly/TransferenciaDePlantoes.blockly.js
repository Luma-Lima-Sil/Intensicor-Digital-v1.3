window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.TransferenciaDePlantoes = window.blockly.js.blockly.TransferenciaDePlantoes || {};

/**
 * TransferenciaDePlantão
 */
window.blockly.js.blockly.TransferenciaDePlantoes.concluirTransferencia = function() {
 var valida;
  valida = true;
  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.medico"))) {
    this.cronapi.screen.notify('error','Informe o médico !');
    valida = false;
  }
  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.medicoDestino"))) {
    this.cronapi.screen.notify('error','Informe o médico de destino !');
    valida = false;
  }
  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.diaSemana"))) {
    this.cronapi.screen.notify('error','Informe o dia da semana !');
    valida = false;
  }
  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.horarioEscala"))) {
    this.cronapi.screen.notify('error','Informe o horário escala !');
    valida = false;
  }
  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.localPlantao"))) {
    this.cronapi.screen.notify('error','Informe o local do plantão !');
    valida = false;
  }
  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.dataTransPlantao"))) {
    this.cronapi.screen.notify('error','Informe a data de transferência do plantão !');
    valida = false;
  }
  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.corSemana"))) {
    this.cronapi.screen.notify('error','Informe a cor da semana !');
    valida = false;
  }
  if (valida == true) {
    this.cronapi.util.callServerBlocklyNoReturn('blockly.TranferirPlantoes:trabsferirPlantoes');
  }
}
