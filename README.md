# Robot-cleaning-squares

In this application a robot have to clean the room. the structure of the project is we have a N*M matrix. there are n number of strings each string has M characters like "...x.." . the robot will have to move forward(cleaning) starting from the top left corner of the matrix only if it see dot "." ,it counts the number of dots it finds but it sees a "x" which means an obstacle so it has to move in clockwise direction i.e by 90 degree.
example is :  
{"...x..","....xx","..x..."}
it should return 6 for this input.
