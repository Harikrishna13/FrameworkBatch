package hai;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Adactin extends BaseClass{
		public Adactin() {
			PageFactory.initElements(driver, this);
		}
		@FindBy(id="username")
		private WebElement txtUserName;
		@FindBy(id="password")
		private WebElement txtPassword;
		@FindBy(id="login")
		private WebElement btnlogin;
		public WebElement getTxtUserName() {
			return txtUserName;
		}
		public WebElement getTxtPassword() {
			return txtPassword;
		}
		public WebElement getBtnlogin() {
			return btnlogin;
		}
		public void logindetails() throws Exception {
			String getcellvalue = getcellvalue("baskar", 0, 0);
			sendKeys(getTxtUserName(), getcellvalue);
			String getcellvalue1 = getcellvalue("baskar", 0, 1);
			sendKeys(getTxtPassword(), getcellvalue1);
			click(getBtnlogin());
			

		}
		

	}



	public class SearchHotel extends Base{
		public SearchHotel() {
			PageFactory.initElements(driver, this);
		}
		@FindBy(id="location")
		private WebElement location;
		
		@FindBy(id="hotels")
		private WebElement hotels;

		@FindBy(id="room_type")
		private WebElement roomtype;

		@FindBy(id="room_nos")
		private WebElement roomnos;

		@FindBy(id="datepick_in")
		private WebElement datepickin;

		@FindBy(id="datepick_out")
		private WebElement datepickout;

		@FindBy(id="adult_room")
		private WebElement adultroom;

		@FindBy(id="child_room")
		private WebElement childroom;

		@FindBy(id="Submit")
		private WebElement Submit;

		public WebElement getLocation() {
			return location;
		}

		public WebElement getHotels() {
			return hotels;
		}

		public WebElement getRoomtype() {
			return roomtype;
		}

		public WebElement getRoomnos() {
			return roomnos;
		}

		public WebElement getDatepickin() {
			return datepickin;
		}

		public WebElement getDatepickout() {
			return datepickout;
		}

		public WebElement getAdultroom() {
			return adultroom;
		}

		public WebElement getChildroom() {
			return childroom;
		}

		public WebElement getSubmit() {
			return Submit;
		}
		public void assertionHotel() {
	WebElement asshotel = findelementByClassName("login_title");
	String text = asshotel.getText();
	Assert.assertEquals("search hotel", "Search Hotel (Fields marked with Red asterix (*) are mandatory)", text);
		}
		public void searchHotelDetails() throws Throwable {
			String getcellvalue = getcellvalue("baskar", 0, 2);
			sendkeys(getLocation(), getcellvalue);
			String getcellvalue1 = getcellvalue("baskar", 0, 3);
			sendkeys(getHotels(), getcellvalue1);
			String getcellvalue2 = getcellvalue("baskar", 0, 4);
			sendkeys(getRoomtype() , getcellvalue2);
			String getcellvalue3 = getcellvalue("baskar", 0, 5);
			sendkeys(getRoomnos(), getcellvalue2);
			String getcellvalue4 = getcellvalue("baskar", 0, 6);
			sendkeys(getDatepickin(), getcellvalue4);
			String getcellvalue5 = getcellvalue("baskar", 0, 7);
			sendkeys(getDatepickout() , getcellvalue5);
			String getcellvalue6 = getcellvalue("baskar", 0, 8);
			sendkeys( getAdultroom() , getcellvalue6);
			String getcellvalue7 = getcellvalue("baskar", 0, 9);
			sendkeys(getChildroom(), getcellvalue7);
			click(getSubmit());
		}


	}


	public class SelectHotel extends Base {
		public SelectHotel() {
			PageFactory.initElements(driver, this);
		}

		@FindBy(id = "radiobutton_0")
		private WebElement radio;
		@FindBy(id = "continue")
		private WebElement continuebtn;

		public WebElement getRadio() {
			return radio;
		}

		public WebElement getContinuebtn() {
			return continuebtn;
		}
		


		public void selecthotel() {
			WebElement asserttext = findelementByClassName("login_title");
			String text = getText(asserttext);
			Assert.assertEquals("verify", "Select Hotel", text);

		}

		public void hotel() {
			click(radio);
			click(continuebtn);
		}

	}


	public class Booking extends Base{
		public Booking() {
			PageFactory.initElements(driver, this);
			
			
		}
		@FindBy(id="first_name")
		private WebElement first;
		@FindBy(id="last_name")
		private WebElement last;
		@FindBy(id="address")
		private WebElement address;
		@FindBy(id="cc_num")
		private WebElement creditno;
		@FindBy(id="cc_type")
		private WebElement credittype;
		@FindBy(id="cc_exp_month")
		private WebElement ccmonth;
		@FindBy(id="cc_exp_year")
		private WebElement ccyear;
		@FindBy(id="cc_cvv")
		private WebElement cvv;
		@FindBy(id="book_now")
		private WebElement bookbtn;
		public WebElement getFirst() {
			return first;
		}
		public WebElement getLast() {
			return last;
		}
		public WebElement getAddress() {
			return address;
		}
		public WebElement getCreditno() {
			return creditno;
		}
		public WebElement getCredittype() {
			return credittype;
		}
		public WebElement getCcmonth() {
			return ccmonth;
		}
		public WebElement getCcyear() {
			return ccyear;
		}
		public WebElement getCvv() {
			return cvv;
		}
		public WebElement getBookbtn() {
			return bookbtn;
		}
		public void bookhoteltext() {
			WebElement booktext = findelementByxpath("//td[text()='Book A Hotel ']");
	String text = booktext.getText();
	Assert.assertEquals("Verify booking is done", "Book A Hotel", text);
		}
		public void bookahotel() throws Throwable {
			String getcellvalue = getcellvalue("baskar", 0, 10);
			sendkeys( getFirst(), getcellvalue);
			String getcellvalue1 = getcellvalue("baskar", 0, 11);
			sendkeys( getLast(), getcellvalue1);
			String getcellvalue2 = getcellvalue("baskar", 0, 12);
			sendkeys( getAddress(), getcellvalue2);
			String getcellvalue3 = getcellvalue("baskar", 0, 13);
			sendkeys(getCreditno(), getcellvalue3);
			String getcellvalue4 = getcellvalue("baskar", 0, 14);
			sendkeys( getCredittype(), getcellvalue4);
			String getcellvalue5 = getcellvalue("baskar", 0, 15);
			sendkeys( getCcmonth(), getcellvalue5);
			String getcellvalue6= getcellvalue("baskar", 0, 16);
			sendkeys( getCcyear(), getcellvalue6);
			String getcellvalue7 = getcellvalue("baskar", 0, 17);
			sendkeys(  getCvv(), getcellvalue7);
			click(getBookbtn());
			

		}
		


	public class bookingId extends Base {
		public bookingId() {
			PageFactory.initElements(driver, this);
			
		}
		@FindBy(id="order_no")
		private WebElement refno;
		public WebElement getRefno() {
			return refno;
		}
		public void reference() throws Throwable {
	String getattribute = getattribute(getRefno());
	System.out.println(getattribute);
	insertcellvalue("baskar", 0,19 , getattribute);
		}

	}




	public class OrderCancel extends Base {
		public OrderCancel() {
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//a[text()='Booked Itinerary']")
		private WebElement booked;
		
		@FindBy(id="order_id_text")
		private WebElement placeorder;
		
		@FindBy(id="search_hotel_id")
		private WebElement go;
		
		@FindBy(xpath="//input[@type='button']")
		private WebElement go1;
		
		


		public WebElement getBooked() {
			return booked;
		}

		public WebElement getPlaceorder() {
			return placeorder;
		}

		public WebElement getGo() {
			return go;
		}
		

		public WebElement getGo1() {
			return go1;
		}
		public void finaly() throws Throwable {
			click(getBooked());
			String getcellvalue = getcellvalue("baskar", 0, 19);
			sendkeys( getPlaceorder(), getcellvalue);
			click( getGo());
			click( getGo1() );
			alertAccept();
			
			
			
		}
		public void cancelBooking() {
			WebElement findelementByxpath = findelementByxpath("//label");
			String text = findelementByxpath.getText();
			Assert.assertEquals("booking cancel", "The booking has been cancelled.", text);
			System.out.println(text);
			
		}
		

	}





	public class Cheching extends Base{
		@BeforeClass
		public static void BeforeClass() {
			launchBrowser("https://adactinhotelapp.com/");
			maximize();
			waiting();
		}
	      @Test
		   public void execution() throws Throwable {
			Adactin l=new Adactin();
			l.logindetails();
			SearchHotel s=new SearchHotel();
			s.assertionHotel();
			s.searchHotelDetails();
			SelectHotel se=new SelectHotel();
			se.selecthotel();
			se.hotel();
			Booking bo=new Booking();
			bo.bookhoteltext();
			bo.bookahotel();
			bookingId b=new bookingId();
			b.reference();
			OrderCancel o=new OrderCancel();
			o.finaly();
			o.cancelBooking();
			
	      }

	      @AfterClass
	      public static void quit() {
	    	  quit();
		}
		}
































}
