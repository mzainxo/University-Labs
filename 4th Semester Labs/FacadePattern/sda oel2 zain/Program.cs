using System;
using sda_oel2_zain.Affiliation;
using sda_oel2_zain.Extensions;
using sda_oel2_zain.MsgQueueing;
using sda_oel2_zain.Notifications;
using sda_oel2_zain.Payments;

namespace sda_oel2_zain
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("\tPAYMENT SERVICE\n");
            PaymentSevice ps = new PaymentSevice();

            Console.WriteLine("\n\tNOTIFICATION SERVICE\n");
            NotificationService ns = new NotificationService();

            Console.WriteLine("\n\tMESSAGE QUEUEING SERVICE\n");
            MessageQueueingService mqs = new MessageQueueingService();

            Console.WriteLine("\n\tAFFILIATE PROGRAM SERVICE\n");
            AffiliateProgramService aps = new AffiliateProgramService();

            Console.WriteLine("\n\tEXTENSION SERVICE\n");
            ExtensionService es = new ExtensionService();
        }
    }
}
