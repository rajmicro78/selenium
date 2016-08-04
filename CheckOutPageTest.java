package com.pack.common.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pack.base.TestBaseSetup;
import com.pack.common.pageobjects.CartPage;
import com.pack.common.pageobjects.CheckOutPage;
import com.pack.common.pageobjects.HomePage;
import com.pack.common.pageobjects.ProductDetailPage;
import com.pack.common.pageobjects.ProductListPage;

public class CheckOutPageTest extends TestBaseSetup {

	private WebDriver driver;
	private ProductListPage productListPage;
	private ProductDetailPage productDetailPage;
	private CartPage cartPage;
	private CheckOutPage checkOutPage;
	
	//Brandsdal (7013) - Collector, Card, Prepayment
	//CPFI (7012) - Card, collector, Prepayment
	//CPSE (7011) - Collector, card, Masterpass
	//CPDK (7010)- Card, Dankort
	//Dl(7009) - Collector, Bankaxess, Card, Prepayment
	//BV(7008) - Collector, Bankaxess, Card, Prepayment, Masterpass
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	
	@Test(priority=4)	 
	public void guestCheckout() throws Exception {
		
		HomePage homepage = new HomePage(driver);
		productListPage = homepage.listMenu();
		productListPage.clickMenu();
		Thread.sleep(2000);
		productDetailPage = productListPage.clickFirstProduct();	
		cartPage = productDetailPage.addtoCart();
		productListPage.cartvalue();
		checkOutPage = cartPage.clickCheckout();
		Thread.sleep(2000);
		checkOutPage.guestCheckout();
		checkOutPage.cardPaymentVisa();
		checkOutPage.orderNumber();
		//COP.validUserCheckout();
	}
	@Test(priority=2)	 
	public void loggedinuserCheckout() throws Exception {
		HomePage homepage = new HomePage(driver);
		productListPage = homepage.listMenu();
		productListPage.clickMenu();
		Thread.sleep(2000);
		productDetailPage = productListPage.clickFirstProduct();
		cartPage = productDetailPage.addtoCart();
		productListPage.cartvalue();
		checkOutPage = cartPage.clickCheckout();
		//cartPage.addSpecialProduct();
		Thread.sleep(2000);
		//checkOutPage.addSpecialProduct();
		checkOutPage.registeredUserCheckout();
		checkOutPage.cardPaymentMaster();
		checkOutPage.orderNumber();
	}
	
	@Test(priority=3)	 
	public void loggedinuserEasyPayment() throws Exception {
		HomePage homepage = new HomePage(driver);
		productListPage = homepage.listMenu();
		productListPage.clickMenu();
		Thread.sleep(2000);
		productDetailPage = productListPage.clickFirstProduct();
		cartPage = productDetailPage.addtoCart();
		productListPage.cartvalue();
		checkOutPage = cartPage.clickCheckout();
		//cartPage.addSpecialProduct();
		Thread.sleep(2000);
		//checkOutPage.addSpecialProduct();
		checkOutPage.registeredUserCheckout();
		checkOutPage.easyPayment();
		checkOutPage.orderNumber();
	}
	
	@Test(groups ={"collector"})	 
	public void loggedinuserCollector() throws Exception {
		//String curURL = context.getCurrentXmlTest().getParameter("appURL");
		//System.out.println(curURL);
		HomePage homepage = new HomePage(driver);
		productListPage = homepage.listMenu();
		productListPage.clickMenu();
		Thread.sleep(2000);
		productListPage.addmultipleProduct();
		productDetailPage = productListPage.clickFirstProduct();
		cartPage = productDetailPage.addtoCart();
		productListPage.cartvalue();
		checkOutPage = cartPage.clickCheckout();
		//cartPage.addSpecialProduct();
		Thread.sleep(2000);
		//checkOutPage.addSpecialProduct();
		checkOutPage.registeredUserCheckout();
		checkOutPage.collector();
		checkOutPage.orderNumber();
	}
	
	@Test(groups ={"dankort"})	 
	public void loggedinuserDankort() throws Exception {
		//String curURL = context.getCurrentXmlTest().getParameter("appURL");
		//System.out.println(curURL);
		HomePage homepage = new HomePage(driver);
		productListPage = homepage.listMenu();
		productListPage.clickMenu();
		Thread.sleep(2000);
		productDetailPage = productListPage.clickFirstProduct();
		cartPage = productDetailPage.addtoCart();
		productListPage.cartvalue();
		checkOutPage = cartPage.clickCheckout();
		//cartPage.addSpecialProduct();
		Thread.sleep(2000);
		//checkOutPage.addSpecialProduct();
		checkOutPage.registeredUserCheckout();
		checkOutPage.dankort();
		checkOutPage.orderNumber();
	}
	
	@Test (groups ={"prepayment"})	 
	//public void guestPrepayment(ITestContext context) throws Exception {
	public void guestPrepayment() throws Exception {
		//String curURL = context.getCurrentXmlTest().getParameter("appURL");
		//String website = curURL.replaceAll("[^0-9]","");
		//System.out.println(website);
		HomePage homepage = new HomePage(driver);
		Thread.sleep(2000);
		productListPage = homepage.listMenu();
		productListPage.clickMenu();
		
		productDetailPage = productListPage.clickFirstProduct();
		cartPage = productDetailPage.addtoCart();
		productListPage.cartvalue();
		checkOutPage = cartPage.clickCheckout();
		//cartPage.addSpecialProduct();
		//checkOutPage.addSpecialProduct();
		Thread.sleep(2000);
		checkOutPage.guestCheckout();
		checkOutPage.prePayment();
		checkOutPage.orderNumber();
	}

}
