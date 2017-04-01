<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Insert title here</title>
</head>
<body>
	<h2>Bem vindo! ${sessionScope.usuLogado.nome}</h2>

  <!-- header -->
  <header>
    <div class="container">
      <nav>
		<c:import url="menu.jsp"></c:import>
      </nav>
    </div>
  </header>
  <div class="main-box">
    <div class="container">
      <div class="inside">
        <div class="wrapper">
        </div>
      </div>
    </div>
  </div>
  <footer>
    <div class="footer">
    </div>
  </footer>
</body>
</html>
