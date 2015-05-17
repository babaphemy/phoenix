<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row-fluid" ng-controller="welcomeController" >
    <div class="jumbotron">
        <h1><spring:message code='project.name'/></h1>

        <p class="lead"><spring:message code='welcomePage.description'/></p>
    </div>
      
        <div class="col-lg-3 col-xs-6">
                	<div class="thumbnail">
                        <div class="caption">
                            <h4><span class="glyphicon glyphicon-pushpin"></span> Users</h4>
                            <p>Add new users, edit existing users, delete users, assign roles, modify users </p>
                            <p><a href="/phoenix2/protected/contacts" class="btn btn-info" data-toggle="tooltip" title="Users Management">::Enter::</a></p>
                        </div>
                    </div>
                </div>
                   <div class="col-lg-3 col-xs-6">
                	<div class="thumbnail">
                        <div class="caption">
                            <h4><span class="glyphicon glyphicon-pushpin"></span> Configuration</h4>
                            <p>System configuration settings</p>
                            <p><a href="/protected/config" class="btn btn-info" data-toggle="tooltip" title="Configurations">::Configure::</a></p>
                        </div>
                    </div>
                </div>
                   <div class="col-lg-3 col-xs-6">
                	<div class="thumbnail">
                        <div class="caption">
                            <h4><span class="glyphicon glyphicon-pushpin"></span> Operations</h4>
                            <p>Zones , Contributions, withdrawals and contributions management.</p>
                            <p><a href="/phoenix2/protected/users" class="btn btn-info" data-toggle="tooltip" title="<spring:message code="header.operations"/>">::Operations:: </a></p>
                        </div>
                    </div>
                </div>
                   <div class="col-lg-3 col-xs-6">
                	<div class="thumbnail">
                        <div class="caption">
                            <h4><span class="glyphicon glyphicon-pushpin"></span> Accounts</h4>
                            <p>Balance sheet, profit and loss, General ledger, accounting operations.</p>
                            <p><a href="/protected/accounts" class="btn btn-info" data-toggle="tooltip" title="Accounts">::Accounts::</a></p>
                        </div>
                    </div>
                </div>
     </div>
     <div class="row">
      <div class="col-lg-3 col-xs-6">
                	<div class="thumbnail">
                        <div class="caption">
                            <h4><span class="glyphicon glyphicon-pushpin"></span> Reports</h4>
                            <p>Customer reports, statements, record of activities.</p>
                            <p><a href="/protected/accounts" class="btn btn-info" data-toggle="tooltip" title="Reports">::Generate Reports::</a></p>
                        </div>
                    </div>
                </div>
                 <div class="col-lg-3 col-xs-6">
                	<div class="thumbnail">
                        <div class="caption">
                            <h4><span class="glyphicon glyphicon-pushpin"></span> Not set</h4>
                            <p>Dogs and cats are susceptible to a variety of illnesses that can be completely prevented by following the appropriate vaccination schedule.</p>
                            <p><a href="#" class="btn btn-info" data-toggle="tooltip" title="Read more about vaccines">Read more >></a></p>
                        </div>
                    </div>
                </div>
                 <div class="col-lg-3 col-xs-6">
                	<div class="thumbnail">
                        <div class="caption">
                            <h4><span class="glyphicon glyphicon-pushpin"></span> Not Set</h4>
                            <p>Dogs and cats are susceptible to a variety of illnesses that can be completely prevented by following the appropriate vaccination schedule.</p>
                            <p><a href="#" class="btn btn-info" data-toggle="tooltip" title="Read more about vaccines">Read more >></a></p>
                        </div>
                    </div>
                </div>
                 <div class="col-lg-3 col-xs-6">
                	<div class="thumbnail">
                        <div class="caption">
                            <h4><span class="glyphicon glyphicon-pushpin"></span> Not Set</h4>
                            <p>Dogs and cats are susceptible to a variety of illnesses that can be completely prevented by following the appropriate vaccination schedule.</p>
                            <p><a href="#" class="btn btn-info" data-toggle="tooltip" title="Read more about vaccines">Read more >></a></p>
                        </div>
                    </div>
                </div>
     </div>
     
     
      <!-- row 3: article/aside -->
    <div class="row">
    	<article class="col-lg-offset-1 col-sm-offset-1 col-lg-8 col-sm-7 col-lg-push-3 col-sm-push-4">
        
            <ol class="breadcrumb">
              <li><a href="#">Home</a> <span class="glyphicon glyphicon-circle-arrow-right"></span></li>
              <li><a href="#">Services</a> <span class="glyphicon glyphicon-circle-arrow-right"></span></li>
              <li class="active">Vaccinations</li>
            </ol>
        
           
            <p><span class="glyphicon-credit-card"></span>
            <p>
            <form name="contactform" method="GET" action="https://stageserv.interswitchng.com/test_paydirect/pay">
            <fieldset>
            <legend>Confirm your payment </legend>
            <input name="product_id" type="hidden" value="<?php echo $pdid ;?>" >
  			<input name="pay_item_id" type="hidden" value="<?php echo $pitem ;?>" >
  			<input name="currency" type="hidden" value="566" >
  			<input name="amount" type="hidden" value="<?php echo $amt1 ; ?>" >
 			 <input name="txn_ref" type="hidden" value="<?php echo $tref ;?>" >
 			 <input name="site_redirect_url" type="hidden" value="<?php echo $rurl ; ?>" ></br>
 			<input name="Mac" type="text" value="<?php echo $dhash;   ?>" > 
  			 <input name="cust_name" type="hidden" value="Test" >
 			  <input name="cust_id" type="hidden" value="AD99" >
            
			<label>Reference : <?php echo $tref ;?>
           <input type="hidden" value="<?php echo $tref ;?>" ><br />
           <label>Amount</label>
           <input name="ama" type="text" value="<?php echo $_SESSION['amt4hash']/100;?>" readonly="readonly" ><br />
           <button type="submit">Pay</button>
            
            
               

</form>
            </p>
            Wisdom Pet Medicine is a state-of-the-art veterinary hospital,   featuring the latest in diagnostic and surgical equipment, and a staff   of seasoned veterinary specialists in the areas of general veterinary   medicine and surgery, oncology, dermatology, orthopedics, radiology,   ultrasound, and much more. We also have a 24-hour emergency clinic in   the event your pet needs urgent medical care after regular business   hours.</p>
            <p>At Wisdom, we strive to be your pet&rsquo;s medical experts from youth   through the senior years. We build preventative health care plans for   each and every one of our patients, based on breed, age, and sex, so   that your pet receives the most appropriate care at crucial milestones   in his or her life. Our overarching goal is to give your pet the best   shot possible at a long and healthy life, by practicing simple   preventative care. We even provide an online Pet Portal where you can   view all your pet&rsquo;s diagnostic results, treatment plans, vaccination and   diagnostic schedules,  prescriptions, and any other health records.</p>
                        <!-- nested row 3a: callouts -->
         <div class="clearfix visible-xs visible-lg"></div>
            <div class="row">
                <div class="col-lg-3 col-xs-6">
                	<div class="thumbnail">
                        <div class="caption">
                            <h4><span class="glyphicon glyphicon-pushpin"></span> Vaccinations</h4>
                            <p>Dogs and cats are susceptible to a variety of illnesses that can be completely prevented by following the appropriate vaccination schedule.</p>
                            <p><a href="#" class="btn btn-info" data-toggle="tooltip" title="Read more about vaccines">Read more >></a></p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-xs-6">
                     <div class="thumbnail">
                        <div class="caption">
                            <h4><span class="glyphicon glyphicon-ok"></span> Checkups</h4>
                            <p>Regular checkups are a key factor in pet wellness, and can often unearth problems that could lead to health issues down the road.  </p>
                            <p><a href="#" class="btn btn-info" data-toggle="tooltip" title="Read more about checkups">Read more >></a></p>
                    	</div>
                    </div>
                </div>
                <div class="clearfix visible-md visible-xs"></div>
                <div class="col-lg-3 col-xs-6">
                	<div class="thumbnail">
                        <div class="caption">
                            <h4><span class="glyphicon glyphicon-heart"></span> Senior Pets</h4>
                            <p>Senior pets generally require more medical attention than their younger counterparts, just as senior humans do. So when is a pet considered “senior”? </p>
                            <p><a href="#" class="btn btn-info" data-toggle="tooltip" title="Read more about senior pets">Read more >></a></p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-xs-6">
                	<div class="thumbnail">
                        <div class="caption">
                    		<h4><span class="glyphicon glyphicon-cutlery"></span> Diet Plans</h4>
                    		<p>Wisdom veterinarians have all had extensive training in pet nutrition and are your best resources when considering changing your pet’s diet. </p>
                     		<p><a href="#" class="btn btn-info" data-toggle="tooltip" title="Read more about diet plans">Read more >></a></p>
                    	</div>
                    </div>
                 </div>
            </div><!-- end nested row 3a -->
        </article>
        <aside class="col-lg-3 col-sm-4 col-lg-pull-9 col-sm-pull-8">
        	<h3>About Our Services</h3>
            <ul class="nav nav-pills nav-stacked">
                <li class="active"><a href="#">Vaccinations</a></li>
                <li><a href="#">Checkups</a></li>
                <li><a href="#">Senior Pets</a></li>
                <li><a href="#">Diet Plans</a></li>
            </ul> 
         </aside>
    

        </div><!-- end row 3 -->
    
           
    

<script src="<c:url value="/resources/js/pages/welcome.js" />"></script>

