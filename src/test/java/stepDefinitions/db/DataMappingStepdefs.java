package stepDefinitions.db;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.digest.DigestUtils;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import pages.SignUpPage;
import utils.DBUtils;
import utils.Driver;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DataMappingStepdefs {

    @When("the user enters the following data in the registration form and clicks sign up:")
    public void the_user_enters_the_following_data_in_the_registration_form_and_clicks_sign_up(List<Map<String,String>> dataTable) {
        Map<String, String> data = dataTable.get(0);
        new SignUpPage().fillTheFormWithData(
                data.get("username"),
                data.get("first_name"),
                data.get("last_name"),
                data.get("email"),
                data.get("password")
                );

        new SignUpPage().clickRegister();

        Assert.assertEquals("URLs don't match", "http://duotify.us-east-2.elasticbeanstalk.com/browse.php?", Driver.getDriver().getCurrentUrl());

    }
    @Then("the data should be mapped correctly to the following columns in the table users:")
    public void the_data_should_be_mapped_correctly_to_the_following_columns_in_the_table_users(List<Map<String,String>>  dataTable) throws SQLException {
        String expUsername = null;
        try{
           expUsername = dataTable.get(0).get("username");
            String expFirst = dataTable.get(0).get("first_name");
            String expLast = dataTable.get(0).get("last_name");
            String expEmail = dataTable.get(0).get("email");
            String expPass = dataTable.get(0).get("password");

            List<Map<String, Object>> actual = DBUtils.getListOfMaps("SELECT * from users where username='" + expUsername + "'");

            String actUsername = (String)(actual.get(0).get("username"));
            String  actFirst = (String) (actual.get(0).get("firstName"));
            String  actLast = (String)(actual.get(0).get("lastName"));
            String  actEmail = (String)(actual.get(0).get("email"));
            String  actPass = (String)(actual.get(0).get("password"));

            SoftAssertions softAssertions = new SoftAssertions();

            softAssertions.assertThat(actUsername).isEqualTo(expUsername);
            softAssertions.assertThat(actFirst).isEqualTo(expFirst);
            softAssertions.assertThat(actLast).isEqualTo(expLast);
            softAssertions.assertThat(actEmail).isEqualTo(expEmail);
            softAssertions.assertThat(actPass).isEqualTo(DigestUtils.md5Hex(expPass));

            softAssertions.assertAll();
        }finally{
            DBUtils.executeUpdate("DELETE FROM users where username='"+expUsername+"'");
        }



    }




    public static void main(String[] args) {


        String converted = DigestUtils.md5Hex("password123");

        System.out.println(converted);

//        482c811da5d5b4bc6d497ffa98491e38

    }
}
