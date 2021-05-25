<%-- 
    Document   : proteccionCivil
    Created on : 5/06/2019, 06:24:24 PM
    Author     : Admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%String context = request.getContextPath();%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SALIF TMX</title>

        <!-- Custom fonts for this template-->
        <link href="<%=context%>/vistas/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="<%=context%>/vistas/css/sb-admin-2.min.css" rel="stylesheet">

    </head>

    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->

            <!-- End of Sidebar -->
            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>



                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">




                            <div class="topbar-divider d-none d-sm-block"></div>

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">Administrador</span>
                                    <img class="img-profile rounded-circle" src="http://temixco.gob.mx/wp-content/uploads/2019/01/logo-jpg-01-1.jpg">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">


                                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Cerrar Sesión
                                    </a>
                                </div>
                            </li>

                        </ul>

                    </nav>
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid">
                        <!-- Page Heading -->
                        <!-- DataTales Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 style="color:#a20303"> SALIF TMX </h6>
                            </div>
                            <div class="card-body">
                                <div class="col-md-12" class="col-md-6" class="col-md-3">

                                    <center>
                                        <h1>Inspecciones pendientes por realizar</h1>
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Número de licencia</th>
                                                    <th>Persona encargada</th>
                                                    <th>Dirección</th>
                                                    <th>Realizar</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <s:if test="%{getLista1().isEmpty()}">
                                                    <tr>
                                                        <td colspan="5"><center>No hay inspecciones por listar</center></td>
                                                </tr>

                                            </s:if>
                                            <s:else>  
                                                <s:iterator value="lista1" status="stat" var="lista1">
                                                    <tr>
                                                        <td><s:property value="#stat.count" /></td>
                                                        <td><s:property value="numeroLicencia"/></td>
                                                        <td><s:property value="personaEncargada"/></td>
                                                        <td><s:property value="direccion"/></td>                          
                                                        <td>
                                                            <form action="proteccionCivilOtro" method="POST">
                                                                <input type="hidden" name="bean.idPc" value="<s:property value="idPc"/>" />                                        
                                                                <button type="submit" value="">Realizado</button>
                                                            </form>
                                                        </td>
                                                    </tr>
                                                </s:iterator>
                                            </s:else>
                                            </tbody>

                                        </table>
                                        <br/>
                                        <br/>
                                        <h1>Inspecciones realizadas</h1>
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Número de licencia</th>
                                                    <th>Persona encargada</th>
                                                    <th>Dirección</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <s:if test="%{getLista2().isEmpty()}">
                                                    <tr>
                                                        <td colspan="5"><center>No hay inspecciones por listar</center></td>
                                                </tr>

                                            </s:if>
                                            <s:else>  
                                                <s:iterator value="lista2" status="stat" var="lista2">
                                                    <tr>
                                                        <td><s:property value="#stat.count" /></td>
                                                        <td><s:property value="numeroLicencia"/></td>
                                                        <td><s:property value="personaEncargada"/></td>
                                                        <td><s:property value="direccion"/></td>                          
                                                    </tr>
                                                </s:iterator>
                                            </s:else>
                                            </tbody>

                                        </table>
                                    </center>
                                </div>
                            </div>
                        </div>

                    </div>
                    <!-- /.container-fluid -->

                </div>
                <!-- End of Main Content -->
                <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                <!-- Footer -->
                <footer class="sticky-footer bg-white">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>Copyright &copy; SALIF TMX 2019</span>
                        </div>
                    </div>
                </footer>
                <!-- End of Footer -->

            </div>
            <!-- End of Content Wrapper -->

        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="login.html">Logout</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal - Eliminar Registro / Baja -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Baja de licencia</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="eliminarLicenciaId" method="POST">
                        <div class="modal-body form-group">
                            <label for="num_Licencia">Ingresa el número de licencia:</label>
                            <input type="text" class="form-control" name="BeanLicencia.no_Licencia" id="inputAddress" placeholder="Ej. 2" required="">
                        </div>
                        <div class="modal-footer form-group">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                            <button type="submit"  class="btn btn-primary">Buscar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Modal - Consulta Normal -->
        <div class="modal fade" id="ConsultarLic" tabindex="-1" role="dialog" aria-labelledby="ConsultarLic" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="ConsultarLic">Consultar Licencia</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="consultarLicenciaId" method="POST">
                        <div class="modal-body form-group">
                            <label for="num_Licencia">Ingresa el número de licencia:</label>
                            <input type="text" class="form-control" name="BeanLicencia.no_Licencia" id="inputAddress" placeholder="Ej. 2" required="">
                        </div>
                        <div class="modal-footer form-group">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                            <button type="submit"  class="btn btn-primary">Buscar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Modal - Modificar Licencia -->
        <div class="modal fade" id="ModificarLic" tabindex="-1" role="dialog" aria-labelledby="ModificarLic" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="ModificarLic">Modificar Licencia</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="consultModifLicencia" method="POST">
                        <div class="modal-body form-group">
                            <label for="num_Licencia">Ingresa el número de licencia:</label>
                            <input type="text" class="form-control" name="BeanLicencia.no_Licencia" id="inputAddress" placeholder="Ej. 2" required="">
                        </div>
                        <div class="modal-footer form-group">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                            <button type="submit"  class="btn btn-primary">Buscar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>



        <!-- Visualizar tarjeton -->
        <div class="modal fade" id="VizTar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="VizTar">Visualizar Tarjeton</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="consultarTarjetonId" method="POST">
                        <div class="modal-body form-group">
                            <label for="idTarjeton">Ingresa el folio del tarjeton</label>
                            <input type="text" class="form-control" name="BeanTarjeton.idTarjeton" id="inputAddress" placeholder="Ej. 200" required="">
                        </div>
                        <div class="modal-body form-group">
                            <label for="idTarjeton">Ingresa el periodo</label>
                            <input type="text" class="form-control" name="BeanTarjeton.periodo" id="inputAddress" placeholder="Ej. 2019" required="">
                        </div>
                        <div class="modal-footer form-group">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                            <button type="submit"  class="btn btn-primary">Buscar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <!-- Modal - Reporte de Tarjeton -->
        <div class="modal fade" id="RepTar" tabindex="-1" role="dialog" aria-labelledby="RepTar" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="RepTar">Reporte de Tarjetones</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="folio">De:</label>
                                <input type="date" class="form-control" id="inputEmail4" placeholder="Giro" >
                            </div>
                            <div class="form-group col-md-4">
                                <label for="folio">A:</label>
                                <input type="date" class="form-control" id="inputEmail4" placeholder="" >
                            </div>
                            <div class="form-group col-md-4">
                                <label for="inputPassword4">Periodo:</label>
                                <input type="number" class="form-control" id="inputPassword4" placeholder="" >
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                        <a class="btn btn-success" href="#">Ok</a>
                    </div>
                </div>
            </div>
        </div>



        <!-- Cancelar tarjeton -->
        <div class="modal fade" id="CanTar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="CanTar">Cancelar Tarjeton</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="cancelarTarjeton" method="POST">
                        <div class="modal-body form-group">
                            <label for="idTarjeton">Ingresa el folio del tarjeton</label>
                            <input type="text" class="form-control" name="BeanTarjeton.idTarjeton" id="inputAddress" placeholder="Ej. 200" required="">
                        </div>
                        <div class="modal-body form-group">
                            <label for="periodo">Ingresa el periodo</label>
                            <input type="text" class="form-control" name="BeanTarjeton.periodo" id="inputAddress" placeholder="Ej. 2019" required="">
                        </div>
                        <div class="modal-footer form-group">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                            <button type="submit"  class="btn btn-primary">Cancelar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <!-- impresion tarjeton -->
        <div class="modal fade" id="ImpTar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="ImpTar">Imprimir Tarjeton</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <label for="folio">Ingresa el folio del tarjeton:</label>
                        <input type="text" class="form-control" id="inputAddress" placeholder="No." required="">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                        <a class="btn btn-success" href="DatosDelTarjeton.html">Ok</a>
                    </div>
                </div>
            </div>
        </div>



        <!-- Generar tarjeton -->
        <div class="modal fade" id="GenTar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="GenTar">Generar Tarjeton</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="registrarTarjeton" method="POST">
                        <div class="modal-body form-group">
                            <label for="periodo">Ingresa el numero de la licencia</label>
                            <input type="text" class="form-control" name="BeanTarjeton.no_Licencia" id="inputAddress" placeholder="Ej. 2019" required="">
                        </div>
                        <div class="modal-footer form-group">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                            <button type="submit"  class="btn btn-primary">Generar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>



        <!-- Bootstrap core JavaScript-->
        <script src="<%=context%>/vistas/vendor/jquery/jquery.min.js"></script>
        <script src="<%=context%>/vistas/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="<%=context%>/vistas/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="<%=context%>/vistas/js/sb-admin-2.min.js"></script>
    </body>
</html>
