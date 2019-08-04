package it.test.java;
class recursion 
    {
        int func (int n) 
        {
            int result;
            result = func (n - 1);
            return result;
        }
    } 
    