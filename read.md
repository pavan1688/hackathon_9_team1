## Mqqt Event Message Handling Test Framework

# Test Framework Design 
Libraries Needs to install 
```pip install paho-mqtt requests pytest-html```

Basic File Structure is here
```
Utils
|_ micscleanous_function.py
|_ pusblish_message.py
Service
|_connect_mqtt.py
Data|_test_data.py
Test
|_conftest.py
|_Integration
    |_test_script.py
|_smoke_tests 
    |_test_script.py
|_end_to_end
    |_test_script.py
Reports
|_log.xml
|_report.html
Read.md
requirments.txt
```
# Execution of this framework 
*Install the requirements provide in the requirements.txt*
```pip install -r requirements.txt```
*execution of the test script*
```python -m pytest --html=report.html```
