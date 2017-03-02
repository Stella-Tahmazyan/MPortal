<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="S" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: levon
  Date: 12/12/16
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1>Improve your information</h1>

<hr/>
<s:set value="%{#application.category}" var="category"/>

<div class="form-group ">
    <form id="formSkill" autocomplete="on" method="post">
        <s:textarea name="user.description" placeholder="Describe you" cssClass="form-control"/>
</div>

<div class="form-group ">

    <s:textarea name="user.experience" placeholder="Experience \",\"" cssClass="form-control"/>
</div>

<div class="form-group ">
    <s:textarea name="user.skills" placeholder="Skills \",\"" cssClass="form-control"/>
</div>

<div class="form-group">
    <select name="category" class="form-control" size="1" id="parentCategory">
        <option value="0">Choose your category</option>
        <s:iterator value="#category" var="parent">
            <option value="<s:property value="key"/>">
                <s:property value="key"/>
            </option>
        </s:iterator>
    </select>


    <s:iterator value="#category" var="parent">
        <s:iterator value="key">
            <s:set value="key" var="k"/>
            <s:select list="value" id="%{#k}" style="height:36px;width: 200px ;display: none; margin-left: 200px"
                      cssClass="categ form-control" size="1" name="%{#k}" listKey="id" listValue="name" headerKey="0"
                      headerValue="-----"/>
        </s:iterator>
    </s:iterator>

</div>

<div class="submit">
    <s:submit value="Save" cssClass="submitForm btn btn-primary btn-lg " onclick="setAction()" />
</div>
</form>






