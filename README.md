# UNSCO Basket Analyser
 A simple GUI utility for generating association rules from ARFF files

UNSCO Basket Analyser (UNSCO BA) lets users generate association rules for market basket analysis via an easy-to-use graphical interface. Users can select a file that contains the data to be analysed, click one button and then view the generated association rules in a table. 

UNSCO Basket Analyser uses the Weka data mining API to generate the association rules using the Apriori algorithm. Hence, only ARFF files can be used with UNSCO BA at present, but later versions will allow the use of CSV files. It is also not possible to change settings for the rule generation, so they use the default Weka settings. The ability to change settings will be added to a future version of UNSCO BA. 

The version of Weka I have doesn't work well with Java 17, so I've used JDK 1.8 to make it. 

![image](https://github.com/user-attachments/assets/8c9508f0-b6c7-4c18-af72-53b5cea1c81f)
