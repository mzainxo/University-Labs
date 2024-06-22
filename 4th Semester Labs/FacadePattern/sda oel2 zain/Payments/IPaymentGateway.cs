using System;

namespace sda_oel2_zain.Payments
{
    public interface IPaymentGateway
    {
        bool ProcessPayment(double amount, string country);
    }
}
