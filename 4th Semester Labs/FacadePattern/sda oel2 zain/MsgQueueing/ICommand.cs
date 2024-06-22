using System;
namespace sda_oel2_zain.MsgQueueing
{
    public interface ICommand
    {
        void Execute();
    }
    public class OrderProcessingCommand : ICommand
    {
        private string order;

        public OrderProcessingCommand(string order)
        {
            this.order = order;
        }
        public void Execute()
        {
            Console.WriteLine("{0} is being proccessed",order);
        }
    }
}
