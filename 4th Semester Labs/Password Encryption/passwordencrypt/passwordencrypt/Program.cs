using System;
using System.Security.Cryptography;
using System.Text;

namespace passwordencrypt
{
    class Program
    {
        
        static void Main(string[] args)
        {
            Console.WriteLine("Enter password: ");
            string password = Console.ReadLine();
            pass p = new pass();
            p.EncryptPass(ref password);
            Console.WriteLine(password);
        }
        
    }
    class pass
    {
        public void EncryptPass(ref string password)
        {
            var sha = SHA256.Create();
            var ByteArr = Encoding.Default.GetBytes(password);
            var encryptPass = sha.ComputeHash(ByteArr);

            password = Convert.ToBase64String(encryptPass);
        }
    }
}
