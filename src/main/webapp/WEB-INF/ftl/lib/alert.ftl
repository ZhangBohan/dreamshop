<div class="alert-information">
    <#list messages as message>
        <div class="alert alert-${message.level}">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            ${ message.message }
        </div>
    </#list>
</div>