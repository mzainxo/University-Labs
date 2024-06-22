using System;
namespace sda_oel2_zain.MsgQueueing
{
    public class MessageQueueingService
    {
        public MessageQueueingService() 
        {
            var orderProcessor = new OrderProcessor();
            orderProcessor.AddCommand(new OrderProcessingCommand("Order1"));
            orderProcessor.AddCommand(new OrderProcessingCommand("Order2"));
            orderProcessor.ProcessCommands();
        }
    }
}
