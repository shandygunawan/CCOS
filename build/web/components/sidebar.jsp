<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<head>
    <link rel="stylesheet" href="assets/css/sidebar.css" />
</head>

<!-- Sidebar -->
<!-- https://bootstrapious.com/p/bootstrap-sidebar -->
<body>
    
    <nav id="sidebar">
        <div class="sidebar-header">
            <span>User ID: <%= session.getAttribute("userId") %></span>
        </div>

        <ul class="list-unstyled components">
            <li id="sidebar-menu-home">
                <a href="/CCOS/homepage.do">Home</a>
            </li>

            <c:choose>
                <c:when test="${sessionScope.role.equals('Administrator')}">
                    <li id="sidebar-menu-application">
                        <a href="#">New Application</a>
                    </li>
                    <li id="sidebar-menu-report">
                        <a href="#">Report</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li>
                        <a id="sidebar-menu-maintenance" href="#maintenance-submenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Maintenance</a>
                        <ul class="collapse list-unstyled" id="maintenance-submenu">
                            <li id="sidebar-submenu-province">
                                <a href="/CCOS/province.do">&emsp;Province</a>
                            </li>
                            <li id="sidebar-submenu-city">
                                <a href="#">&emsp;City</a>
                            </li>
                        </ul>
                    </li>
                    <li id="sidebar-menu-user">
                        <a href="/CCOS/user-search.do">User</a>
                    </li>
                </c:otherwise>
            </c:choose>
            <li id="sidebar-menu-logout">
                <a href="#">Logout</a>
            </li>
        </ul>
    </nav>
</body>