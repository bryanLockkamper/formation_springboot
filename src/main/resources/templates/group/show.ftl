<#include "../layout.ftl">
<@main>
    <h1>Show group</h1>
    <div>
        ${group.label}
    </div>
    <ul>
        <#list group.roles as role>
            <li>${role.label}</li>
        </#list>
    </ul>
</@main>