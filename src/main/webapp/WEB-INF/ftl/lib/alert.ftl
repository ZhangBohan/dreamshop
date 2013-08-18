<#list messages as message>
    <div class="alert alert-${message.level.level}">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
        <strong>${message.level.title}</strong> ${message.message}.
    </div>
</#list>