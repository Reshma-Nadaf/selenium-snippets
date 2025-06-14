module APIProject {
	requires rest.assured;
	requires org.hamcrest;
	requires json.path;
	requires org.testng;
	    exports TestPackage to org.testng;

}