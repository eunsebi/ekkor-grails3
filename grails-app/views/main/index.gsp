<%--
  Created by IntelliJ IDEA.
  User: eunse
  Date: 2019-01-13
  Time: 오후 3:16
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <meta name="layout" content="main_with_banner"/>
        <title>All That Community</title>
    </head>

    <body>
        <g:sidebar/>

        %{--<g:banner type="MAIN" />--}%

        <div id="index" class="content scaffold-list clearfix" role="main">
            main Page

        </div>
        <content tag="script">
            <script>
                $(function () {
                    $('.timeago')
                        .timeago();
                });
            </script>
        </content>
    </body>
</html>