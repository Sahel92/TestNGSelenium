# TestNGSelenium
TestNG Selenium Framework (POM) Design
Dev

06/16/23

    Improved logger initialization using the LogManager.getLogger() method.
    Added a BaseSetup.class reference to the logger for better logging.
    Changed the @SuppressWarnings("rawtypes") annotation to @SuppressWarnings("unchecked") for clarity.
    Removed the unnecessary System.out.println(uiProperties) statement.
    Simplified the switch statement for browser selection.
    Moved the logger error message and exception logging to the catch block.
    Removed the unnecessary casting of the logger.
    Added the static final modifier to the logger to ensure it is shared among instances.
    Updated the exception message in the RuntimeException for unknown browsers.
    Reorganized imports and added import statements for Logger and LogManager.
