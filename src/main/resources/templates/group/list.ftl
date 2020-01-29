<#include "../layout.ftl">

<@main>
    <h1>List Group</h1>

    <ul>
        <#list groups as group>
            <li>${group.label}</li>
        </#list>
    </ul>
</@main>