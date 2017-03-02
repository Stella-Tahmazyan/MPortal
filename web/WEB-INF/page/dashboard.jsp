<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="S" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: levon
  Date: 12/11/16
  Time: 10:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-xs-12">
    <h1><span class="badge"><span class="glyphicon glyphicon-home"></span></span> My Dashboard</h1>
</div>

<div id="scon" class="col-sm-12 col-md-4">
    <div class="row">
        <div class="col-sm-6 col-md-12">

            <div class="panel panel-default profile-card">
                <div class="panel-heading">My Profile &amp; Settings</div>
                <div class="panel-body">


                    <div class=" clearfix media">
                        <div class="pull-left">
                            <a href="#" title="View Levon Aloyan's Profile">
                                <img src="image?id=<s:property value="user.id"/> " height="40" width="40"
                                     class="profile-pic img-circle"/>
                            </a></div>
                        <div class="media-body">
                            <%--username--%>
                            <p class="user-name">

                                <a><s:property value="user.name"/> <s:property value="user.surname"/></a></p>
                            <hr/>

                            <%--Country--%>
                            <%--<p class="user-info">--%>
                            <%--<small>--%>
                            <%--<span class="glyphicon glyphicon-map-marker"></span> United States<br/>--%>
                            <%--</small>--%>
                            <%--</p>--%>
                            <%--<p class="user-info">--%>
                            <%--<small>--%>
                            <%--<span class="glyphicon glyphicon-book"></span> Java <br/>--%>
                            <%--</small>--%>
                            <%--</p>--%>
                            <%--<p class="user-info">--%>
                            <%--<small>--%>
                            <%--<span class="glyphicon glyphicon-star"></span> Junior <br/>--%>
                            <%--</small>--%>
                            <%--</p>--%>
                            <%--<p class="user-info">--%>
                            <%--<small>--%>
                            <%--<span class="glyphicon glyphicon-phone"></span> 098133996 <br/>--%>
                            <%--</small>--%>
                            <%--</p>--%>
                            <%--<p class="user-info">--%>
                            <%--<small>--%>
                            <%--<span class="glyphicon glyphicon-flag"></span> Armenian <br/>--%>
                            <%--</small>--%>
                            <%--</p>--%>

                        </div><!-- end .media-body -->


                    </div> <!-- end .well or footer_class -->
                    <div class="clearfix wrapper">
                        <hr/>
                        <p>
                            <%--your information--%>
                        <p>About us</p>
                        </p>
                        <a class="btn btn-tertiary btn-lg btn-block" href="/getManageProfile">Manage Profile &amp;
                            Settings</a>
                    </div> <!-- end dashboard's .clearfix or footer_class or .affinity-bar -->
                </div>
            </div>

        </div>


    </div>
</div>
<div id="pcon" class="col-sm-12 col-md-8">
    <div class="row">


        <div class="col-xs-12">
            <div class="panel panel-default">

                <div class="panel-heading "><span class="glyphicon glyphicon-envelope"></span> My Conversations</div>
                <div class="panel-body">
                    <div class="alert alert-warning"><span class="glyphicon glyphicon-exclamation-sign"></span>
                        You haven't connected with any mentors yet. <a href="/people/search/mentors"
                                                                       class="btn btn-primary btn-md pull-right dashboard-button"
                                                                       style="margin-top: -7px;">Search for
                            Mentors</a>
                    </div>
                    <%--else--%>
                    <%--iterator--%>
                    <div class="mm-wgt panel panel-default pos-relative">

                        <div class="panel-body media ">
                            <div class="pull-left">
                                <a href="profile.action"
                                   title="View Ruben Sharyan's Profile">
                                    <img class="profile-pic img-circle" src="/images/MPLogo120.png"
                                         alt="Ruben Sharyan"/>
                                </a></div>
                            <div class="media-body">

                                <div class="row">
                                    <div class="col-sm-3">
                                        <strong><a href="profile.action">Ruben
                                            Sharyan</a></strong><br/>

                                        12/14/2016<br/>
                                        mentor<br/>
                                    </div>
                                    <div class="col-sm-9">
                                        <a href="message.action"
                                           class="btn btn-primary pull-right hidden-xs">View</a>
                                        <div class="col-sm-8">
                                            <div>
                                                <p>fghjkl;</p></div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 visible-xs">
                                        <a href="allConversation.action" class="btn btn-primary">View</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%----%>
                </div>
            </div>
        </div>


        <div class="col-xs-12 visible-xs">
            <div class="panel panel-default" id="groups">
                <div class="panel-heading">My Groups</div>
                <div class="panel-body">
                    <div class="alert alert-warning"><span class="glyphicon glyphicon-exclamation-sign"></span>
                        You have not <a href="/groups/search">joined</a> any Groups yet.
                    </div>
                </div>
            </div>
        </div>


    </div>
</div>
