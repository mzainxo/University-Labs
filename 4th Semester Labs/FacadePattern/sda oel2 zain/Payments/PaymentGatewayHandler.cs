using System;
using System.Collections.Generic;

namespace sda_oel2_zain.Payments
{
    public class PaymentGatewayHandler
    {
        private List<IPaymentGateway> gateways;

        public PaymentGatewayHandler()
        {
            gateways = new List<IPaymentGateway>
            {
                new PayPal(),
                new EasyPaisa()
            };
        }

        public bool ProcessPayment(double amount, string country)
        {
            foreach (var gateway in gateways)
            {
                if (IsGatewayAvailableForCountry(gateway, country))
                {
                    var paymentSuccess = gateway.ProcessPayment(amount, country);
                    if (paymentSuccess)
                    {
                        Console.WriteLine("PAYMENT PROCESSED SUCCESSFULLY");
                        return true;
                    }
                }
            }
            return false; //all gateways failed
        }

        private bool IsGatewayAvailableForCountry(IPaymentGateway gateway, string country)
        {
            Console.WriteLine("{0} gateway available for {1}", gateway.GetType().Name, country);
            //country payment gateway availibility check
            return true;
        }
    }
}
