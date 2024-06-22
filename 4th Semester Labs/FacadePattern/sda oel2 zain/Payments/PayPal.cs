using System;

namespace sda_oel2_zain.Payments
{
    class PayPal : IPaymentGateway
    {
        public bool ProcessPayment(double amount, string country)
        {
            Console.WriteLine("Payment Processing through Paypal");
            //implementation
            return true;
        }
    }
}
