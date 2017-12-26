# Amazon - Test Automation.
## What is it?
It is an automation test following the steps bellow using Selenium WebDriver, TestNG, Java,Cucumber and Maven.

## Steps
1. Go Navigate to Amazon web-site
2. Go into "Best sellers in Digital Cameras"
3. Open details of 5-th product
4. Add 8 pieces to the shopping cart (don't accept any other options that are proposed by the e-shop)
## Expected Result
1. Correct product name was added and subtotal price sum is correct

PS: If the product has less than 8 items, test the maximum number of items that can be inserted. Even as if the Add to cart button does not show the test will be failed.
