const eBotones = {
    YES:'<button type="button" id="btnOkModal" class="btn btn-primary" data-dismiss="modal">OK</button>',
    YESNO: '<button type="button" id="btnYesModal" class="btn btn-primary" data-dismiss="modal">OK</button>'
    +'<button type="button" id="btnNoModal" class="btn btn-secondary" data-dismiss="modal">No</button>',
    GUARDARCANCEL: '<button type="button" id="btnGuardarModal" class="btn btn-primary">Guardar</button>'
    +'<button type="button" id="btnCancelModal" class="btn btn-danger" data-dismiss="modal">Cancelar</button>',
    YESCANCEL: '<button type="button" id="btnOkModal" class="btn btn-primary" data-dismiss="modal">OK</button>'
    +'<button type="button" id="btnCancelModal" class="btn btn-danger" data-dismiss="modal">Cancelar</button>',
    YESNOCANCEL: '<button type="button" id="btnOkModal" class="btn btn-primary" data-dismiss="modal">OK</button>'
    +'<button type="button" id="btnNoModal" class="btn btn-secondary" data-dismiss="modal">No</button>'+
    '<button type="button" id="btnCancelModal" class="btn btn-danger" data-dismiss="modal">Cancelar</button>'
};
const eIconos = {
    ERROR:'<i class="fas fa-times-circle fa-3x" style="color:D56B6B"></i>',
    INFO:'<i class="fas fa-info-circle fa-3x" style="color:ECC054 "></i>',
    SUCCESS:'<i class="fas fa-check-circle  fa-3x" style="color:6BD57B"></i>',
};

    var modalDialog =  (function(){

        function CrearDialog(p_sTitulo = 'Titulo',p_sMensaje = 'Mensaje',p_dialogContainterId,Botones = eBotones.YES,Iconos = eIconos.INFO){

            var modalHtml = '<div class="modal fade" style="display:block; z-index:10000" aria-hidden="true" role="dialog" id="'+p_dialogContainterId+'"><div class="modal-dialog">'
            +'<div class="modal-content" >'
                +'<div class="modal-header" style="display: flex; justify-content: center; align-items: center;">'
                +Iconos
                    +'<h5 class="modal-title" id="TituloModal"> &nbsp;&nbsp;'+p_sTitulo+'</h5>'
                    +'<button type="button" class="close" data-dismiss="modal">'
                        +'<span>&times;</span>'
                   +'</button>'
                +'</div>'
                +'<div class="modal-body">'
                    +'<p id="ContenidoModal">'+p_sMensaje+'</p>'
               +'</div>'
                +'<div class="modal-footer">'
                    +Botones
                +'</div>'
            +'</div>'
        +'</div></div>';

        return modalHtml;
        }

        function CrearModal(p_sTitulo = 'Titulo', p_sCuerpoHtml = 'Cuerpo',Botones= eBotones.YESCANCEL,p_idDiv){

            var modalHtml = '<div class="modal fade" id="'+p_idDiv+'"><div class="modal-dialog modal-dialog-scrollable modal-lg">'
            +'<div class="modal-content">'
                +'<div class="modal-header">'
                    +'<h5 class="modal-title" id="TituloModal">'+p_sTitulo+'</h5>'
                    +'<button type="button" class="close" data-dismiss="modal">'
                        +'<span>&times;</span>'
                   +'</button>'
                +'</div>'
                +'<div class="modal-body">'
                    +p_sCuerpoHtml
               +'</div>'
                +'<div class="modal-footer" id="BotoneraModal">'
                +Botones
                +'</div>'
            +'</div>'
        +'</div></div>';

        return modalHtml;
        }

        function CrearToast(p_sTitulo = 'Titulo', p_sCuerpoHtml = 'Cuerpo'){
            var toastHtml =
            '<div class="toast" role="alert" aria-live="assertive" aria-atomic="true"'+
             'style="position: absolute; top: 0; right: 0; z-index:-1" data-delay="1000" id="toastDialog">'
              +'<div class="toast-header">'
                +'<img src="img/proceIcon.png" style="width:25px; height:25px; " class="rounded mr-2">'
                +'<strong class="mr-auto">'+p_sTitulo+'</strong>'
                +'<small>ahora</small>'
                +'<button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">'
                  +'<span aria-hidden="true">&times;</span>'
                +'</button>'
              +'</div>'
              +'<div class="toast-body">'
              + p_sCuerpoHtml
              +'</div>'
            +'</div>';

          return toastHtml;
        }

        var $waitingDialog =
            '<div id="waitingDialog" class="modal fade" data-backdrop="static"'+
            'data-keyboard="false" tabindex="-1" role="dialog" aria-hidden="true"'+
            ' style="padding-top:15%; overflow-y:visible;">' +
            '<div class="modal-dialog modal-m">' +
            '<div class="modal-content">' +
                '<div class="modal-header"><h3 style="margin:0;"></h3></div>' +
                '<div class="modal-body" align="center" style:width:200px;>' +
                    '<img src="../img/Cargando.gif" style=" aling width:100px; height:100px"></img>' +
                '</div>' +
            '</div></div></div>';

        return {
            showDialog : function(p_sTitulo = '',p_sMensaje = '',Botones,Icono,callback,p_containerId = "modalDialogContainer")
            {
                var modalHtml = CrearDialog( p_sTitulo,p_sMensaje,p_containerId,Botones,Icono);

                var $modalDialogContainer = $("#"+p_containerId);

                $modalDialogContainer.replaceWith(modalHtml);

                $("#"+p_containerId).modal();

                $('#myModal').on('hidden.bs.modal', function (e) {
                    $("#"+p_containerId).modal('hide');
                    $(".modal-backdrop").remove();
                  })

                if (!callback)
                {
                    callback = function(){};
                }

                $("#btnYesModal").click(function (e) {
					e.preventDefault();
                   callback(true);
                });

				$("#btnOkModal").click(function (e) {
					callback();
                });

                $("#btnNoModal").click(function (e) {
                    callback(false);
                 });


            },
            showModal : function(p_sCuerpoHtml = '',p_sTitulo = '',Botones,callback,p_containerId = "modalContainer"){

                let modalHtml = CrearModal(p_sTitulo,p_sCuerpoHtml,Botones,p_containerId);

                let $modalContainer = $("#"+p_containerId)

                $modalContainer.replaceWith(modalHtml);

                $("#"+p_containerId).modal();

                $("#"+p_containerId).on('hide.bs.modal', function (e) {

                    if(callback)
                    {
                        callback();
                    }
                  })

            },
            showToast : function(p_sCuerpoHtml = '',p_sTitulo = '',p_containerId = "toastDialog"){

                var toastHtml = CrearToast(p_sCuerpoHtml, p_sTitulo);

                var $toastContainer = $("#"+p_containerId)

                $toastContainer.replaceWith(toastHtml);

                $(".toast").toast('show');

            },
            showWaitingDialog: function (p_sMensaje, p_options) {

                $("#waitingDialog").replaceWith($waitingDialog);

                var $dialog = $("#waitingDialog");

                if (typeof p_options === 'undefined') {
                    p_options = {};
                }
                if (typeof p_sMensaje === 'undefined') {
                    p_sMensaje = 'Cargando...';
                }
                var settings = $.extend({
                    dialogSize: 'm',
                    progressType: 'default',
                    onHide: null
                }, p_options);

                $dialog.find('.modal-dialog').attr('class', 'modal-dialog').addClass('modal-' + settings.dialogSize);
                $dialog.find('.progress-bar').attr('class', 'progress-bar');
                if (settings.progressType) {
                    $dialog.find('.progress-bar').addClass('progress-bar-' + settings.progressType);
                }
                $dialog.find('h3').text(p_sMensaje);
                if (typeof settings.onHide === 'function') {
                    $dialog.off('hidden.bs.modal').on('hidden.bs.modal', function (e) {
                        settings.onHide.call($dialog);
                    });
                }
                  $dialog.modal('show');
            },
            hidewWaitingDialog: function () {
                $("#waitingDialog").modal('hide');
                $(".modal-backdrop").remove();
                setTimeout(function () {
                    $("#waitingDialog").modal('hide');
                }, 2000)
            },


            }
    })();


