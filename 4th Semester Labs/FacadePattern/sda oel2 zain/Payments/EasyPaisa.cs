using System;

namespace sda_oel2_zain.Payments
{
    class EasyPaisa : IPaymentGateway
    {
        public bool ProcessPayment(double amount, string country)
        {
            Console.WriteLine("Payment Processing through Easypaisa");
            //implementation
            return true;
        }
    }
}
