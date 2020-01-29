<#include "../layout.ftl">
<@main>
    <h1>Create</h1>
    <form method="post" action="/group/create">
        <label for="label">Label:</label>
        <input id="label" name="label">
        <button type="submit">Create</button>
    </form>
</@main>