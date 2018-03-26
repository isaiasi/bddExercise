'''
Created on Mar 26, 2018

@author: isaiasi
'''
from behave import *
from selenium import webdriver
from selenium.webdriver.support.wait import WebDriverWait

chromeDriverPath = "/Users/isaiasi/QA/Automation/Selenium/chromedriver";
driver = webdriver.Chrome(chromeDriverPath)
wait = WebDriverWait(driver, 10)

appURL = "http://store.demoqa.com/";
userName = "isaiasif";
userPassword = "^iu51bQFv#fHv*2k";

@given('user is on the home page')
def step_impl(context):
    pass

@when('we implement a test')
def step_impl(context):
    assert True is not False

@then('behave will test it for us!')
def step_impl(context):
    assert context.failed is False