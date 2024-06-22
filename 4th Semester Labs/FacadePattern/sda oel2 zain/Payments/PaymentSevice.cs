using System;

namespace sda_oel2_zain.Payments
{
    class PaymentSevice
    {
        public PaymentSevice()
        {
            var handler = new PaymentGatewayHandler();
            bool paymentSuccess = handler.ProcessPayment(25000, "Saudi Arabia");
        }
    }
}
