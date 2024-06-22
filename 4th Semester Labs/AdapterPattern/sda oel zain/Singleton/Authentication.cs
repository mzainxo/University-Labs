using System;
namespace sda_oel_zain.Singleton
{
    class Authentication
    {
        private static Authentication instance;
        private Authentication() 
        {
            //some authentication logic
        }
        public static Authentication getInstance()
        {
            if (instance == null)
            {
                instance = new Authentication();
                Console.WriteLine("First instance created.");
                return instance;
            }
            else
            {
                Console.WriteLine("Instance already created!!");
                return instance;
            }
        }
        public bool AuthenticateUser(string username, string password)
        {
            // logic to authenticate the user
            // return true if the user is authenticated. otherwise, return false
            return true;
        }
        // other authentication methods and properties
    }
}
