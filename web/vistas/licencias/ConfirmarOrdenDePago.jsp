<%-- 
    Document   : OrdenDePago
    Created on : 12/07/2019, 07:43:48 PM
    Author     : BELTRAN PC
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
        <!--<link href="<%=context%>/vistas/css/drag.css" rel="stylesheet">-->

    </head>

    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">
            <div id="breadcrumbs-wrapper" class=" grey lighten-3">
                <div class="container">
                    <div class="row">
                        <div class="col s12 m12 l12">

                        </div>
                    </div>
                </div>
            </div>


            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-danger sidebar sidebar-dark accordion" id="accordionSidebar">

                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                    <div class="sidebar-brand-icon rotate-n-10">
                        <i class="fas fa-users-cog"></i>
                    </div>
                    <div class="sidebar-brand-text mx-3">Administrador TMX</div>
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">


                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->

                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Padrones</span>
                    </a>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Lista de opciones:</h6>
                            <a class="collapse-item" href="<%=context%>/registroLicencia">Altas</a>
                            <a class="collapse-item" data-toggle="modal" data-target="#exampleModal">Bajas</a>
                            <a class="collapse-item" data-toggle="modal" data-target="#ConsultarLic">Consultar</a>
                            <a class="collapse-item" data-toggle="modal" data-target="#ModificarLic">Modificar</a>
                            <a class="collapse-item" href="<%=context%>/generarPadron">Generaci??n de padrones</a>
                            <a class="collapse-item" data-toggle="modal" data-target="#InspeccionLic">Inspecci??n Licencia</a>
                        </div>
                    </div>
                </li>

                <!-- Nav Item - Utilities Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities1" aria-expanded="true" aria-controls="collapseUtilities">
                        <i class="fab fa-accusoft"></i>
                        <span>Tarjetones</span>
                    </a>
                    <div id="collapseUtilities1" class="collapse" aria-labelledby="headingUtilities1" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Lista de opciones:</h6>
                            <a class="collapse-item" data-toggle="modal" data-target="#ImpTar"> Impresi??n de tarjetones</a>
                            <a class="collapse-item" data-toggle="modal" data-target="#RepTar">Reporte de tarjetones</a>
                            <a class="collapse-item" data-toggle="modal" data-target="#VizTar">Visualizar tarjet??n</a>
                            <a class="collapse-item" data-toggle="modal" data-target="#GenTar">Generar tarjet??n</a>
                            <a class="collapse-item" data-toggle="modal" data-target="#CanTar">Cancelaci??n de tarjetones</a>
                        </div>
                    </div>
                </li>

                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
                        <i class="far fa-money-bill-alt"></i>
                        <span>Transacciones/Cajas</span>
                    </a>
                    <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Lista de opciones:</h6>
                            <a class="collapse-item" href="ordenDePago.jsp">Generar orden de pago</a>
                            <a class="collapse-item" href="abonarPago.jsp">Abonar pagos</a>
                        </div>
                    </div>
                </li>


                <!-- Nav Item - Utilities Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities3" aria-expanded="true" aria-controls="collapseUtilities3">
                        <i class="fas fa-fw fa-wrench"></i>
                        <span>Configuaraci??n</span>
                    </a>
                    <div id="collapseUtilities3" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Lista de opciones:</h6>
                            <a class="collapse-item" href="buttons.html">General (Municipios)</a>
                            <a class="collapse-item" href="cards.html">Parametros generales</a>
                        </div>
                    </div>
                </li>



                <!-- Nav Item - Utilities Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities78" aria-expanded="true" aria-controls="collapseUtilities78">
                        <i class="fas fa-fw fa-wrench"></i>
                        <span>Configuracion de costos</span>
                    </a>
                    <div id="collapseUtilities78" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Lista de opciones:</h6>
                            <a class="collapse-item" href="buttons.html">Uso del suelo</a>
                            <a class="collapse-item" href="cards.html">Tipos de zonas</a>
                            <a class="collapse-item" href="cards.html">Usos del suelo</a>
                        </div>
                    </div>
                </li>


                <!-- Nav Item - Utilities Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities55" aria-expanded="true" aria-controls="collapseUtilities55">
                        <i class="fas fa-fw fa-wrench"></i>
                        <span>C??talogo de actividades </span>
                    </a>
                    <div id="collapseUtilities55" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Lista de opciones:</h6>
                            <a class="collapse-item" href="buttons.html">Tipo de actividades</a>
                        </div>
                    </div>
                </li>

                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities456" aria-expanded="true" aria-controls="collapseUtilities456">
                        <i class="fas fa-comment"></i>
                        <span>Estados</span>
                    </a>
                    <div id="collapseUtilities456" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Lista de opciones:</h6>
                            <a class="collapse-item" href="buttons.html">Estados de licencia </a>
                            <a class="collapse-item" href="buttons.html">Veredicto </a>
                        </div>
                    </div>
                </li>

                <!-- Nav Item - Charts -->
                <li class="nav-item">
                    <a class="nav-link" href="charts.html">
                        <i class="fas fa-fw fa-chart-area"></i>
                        <span> Cuentas contables</span></a>
                </li>
                <!-- Divider -->
                <hr class="sidebar-divider d-none d-md-block">

                <!-- Sidebar Toggler (Sidebar) -->
                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>

            </ul>
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
                                        Cerrar Sesi??n
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
                                <h6 style="color:#a20303"> Conceptos a pagar orden de pago</h6>
                            </div>



                            <form action="consultarCuentaContableCuenta" method="POST">
                                <div class="form-row">

                                    <div class="form-group col-md-6">
                                        <label for="folio">Buscar por cuenta:</label>
                                        <input  type="text" class="form-control" name="beanCuentasContables.cuenta" id="inputAddress" placeholder="Concepto">

                                    </div>

                                    <div class="form-group col-md-4">
                                        <br>
                                        <button type="submit" class="btn btn-success openBtn">Buscar</button>

                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <br><br>


                    <table class="table table-hover"data-draggable="target">
                        <thead class="thead-dark">
                            <tr data-draggable="item">
                                <th scope="col">#</th>
                                <th scope="col">Concepto</th>
                                <th scope="col">Cuenta</th>
                                <th scope="col">UMAS</th>

                            </tr>
                        </thead>
                        <tbody>

                            <s:iterator value="listaCuentasContablesPreview" status="stat" var="lista">


                                <tr data-draggable="item">
                                    <td><s:property value="#stat.count"/></td>
                                    <td><s:property value="concepto"/></td>
                                    <td><s:property value="cuenta"/></td>
                                    <td><s:property value="UMAS"/></td>

                                </tr>
                            </s:iterator>
                        </tbody>

                    </table>
                    <br><br><br>
                    <div class="form-group">
                        <label for="inputPassword4">Total:</label>
                        <input type="text" name="totalPago" value="<s:property value="totalPago"/>" class="form-control mx-sm-3" disabled="">
                    </div>
                    <div class="form-group">
                        <form action="eliminarOrdenDePago" method="POST">
                            <div class="form-row">
                                <button type="submit" class="btn btn-danger ">Cancelars</button>
                            </div>
                        </form>
                    </div>
                    <form action="<%=context%>/registrarOrdenDePagoConceptos" method="POST">
                        <div class="form-row">                 
                            <div class="form-group col-md-12">

                                <input type="hidden" name="idsCuentasContables" id="idsCuentasContables" value="<s:property value="idsCuentasContables"/>" />
                                <input class="btn btn-success btn-lg btn-block" onclick="cargarIdsConceptos()" type="submit" value="Confirmar pago">
                            </div>
                        </div>
                    </form>


                    <div class="h-30"></div>
                </div>
            </div>
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
                    <span aria-hidden="true">??</span>
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
                    <label for="num_Licencia">Ingresa el n??mero de licencia:</label>
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

<!-- Modal - Solicitar Inspeccion / Baja -->
<div class="modal fade" id="InspeccionLic" tabindex="-1" role="dialog" aria-labelledby="InspeccionLic" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="InspeccionLic">Solicitar Inspecci??n</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="solicitarInspeccion" method="POST">
                <div class="modal-body form-group">
                    <label for="num_Licencia">Ingresa el n??mero de licencia:</label>
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
                    <label for="num_Licencia">Ingresa el n??mero de licencia:</label>
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
                    <label for="num_Licencia">Ingresa el n??mero de licencia:</label>
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
<script>
    (function ()
    {

        //exclude older browsers by the features we need them to support
        //and legacy opera explicitly so we don't waste time on a dead browser
        if
                (
                        !document.querySelectorAll
                        ||
                        !('draggable' in document.createElement('span'))
                        ||
                        window.opera
                        )
        {
            return;
        }

        //get the collection of draggable items and add their draggable attribute
        for (var
                items = document.querySelectorAll('[data-draggable="item"]'),
                len = items.length,
                i = 0; i < len; i++)
        {
            items[i].setAttribute('draggable', 'true');
        }

        //variable for storing the dragging item reference 
        //this will avoid the need to define any transfer data 
        //which means that the elements don't need to have IDs 
        var item = null;

        //dragstart event to initiate mouse dragging
        document.addEventListener('dragstart', function (e)
        {
            //set the item reference to this element
            item = e.target;

            //we don't need the transfer data, but we have to define something
            //otherwise the drop action won't work at all in firefox
            //most browsers support the proper mime-type syntax, eg. "text/plain"
            //but we have to use this incorrect syntax for the benefit of IE10+
            e.dataTransfer.setData('text', '');

        }, false);

        //dragover event to allow the drag by preventing its default
        //ie. the default action of an element is not to allow dragging 
        document.addEventListener('dragover', function (e)
        {
            if (item)
            {
                e.preventDefault();
            }

        }, false);

        //drop event to allow the element to be dropped into valid targets
        document.addEventListener('drop', function (e)
        {
            //if this element is a drop target, move the item here 
            //then prevent default to allow the action (same as dragover)
            if (e.target.getAttribute('data-draggable') == 'target')
            {
                e.target.appendChild(item);

                e.preventDefault();
            }

        }, false);

        //dragend event to clean-up after drop or abort
        //which fires whether or not the drop target was valid
        document.addEventListener('dragend', function (e)
        {
            item = null;

        }, false);

    })();
</script>
<script src="js/OrdenDePago.js"></script>    
<script src="<%=context%>/vistas/vendor/jquery/jquery.min.js"></script>
<script src="<%=context%>/vistas/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="<%=context%>/vistas/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="<%=context%>/vistas/js/sb-admin-2.min.js"></script>
</body>
</html>
