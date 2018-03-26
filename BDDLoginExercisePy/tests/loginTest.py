'''
Created on Mar 25, 2018

@author: isaiasi
'''
import unittest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions

class LoginTest(unittest.TestCase):


    def setUp(self):
        chromeDriverPath = "/Users/isaiasi/QA/Automation/Selenium/chromedriver";
        self.driver = webdriver.Chrome(chromeDriverPath)
        self.wait = WebDriverWait(self.driver, 10)


    def test_LoginTest(self):
        #data strings
        appURL = "http://store.demoqa.com/";
        userName = "isaiasif";
        userPassword = "^iu51bQFv#fHv*2k";
        
        #go to page and click on My Account
        self.driver.get(appURL)
        myAccountLink = self.driver.find_element_by_xpath("//*[@id=\"account\"]/a")
        myAccountLink.click()
        
        #enter credentials and log in
        self.wait.until(expected_conditions.presence_of_element_located((By.ID,"log")))
        usernameTextbox = self.driver.find_element_by_id("log")
        passwordTextbox = self.driver.find_element_by_id("pwd")
        loginButton = self.driver.find_element_by_id("login")
        usernameTextbox.send_keys(userName)
        passwordTextbox.send_keys(userPassword)
        loginButton.click()
        
        #logout
        self.wait.until(expected_conditions.presence_of_element_located((By.XPATH, "//*[@id=\"account_logout\"]/a")))
        logoutButton = self.driver.find_element_by_xpath("/*[@id=\"account_logout\"]/a")
        logoutButton.click()


    def tearDown(self):
        self.driver.quit()
