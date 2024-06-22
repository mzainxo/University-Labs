using System;
using System.Collections.Generic;
namespace sda_oel2_zain.MsgQueueing
{
    public class OrderProcessor
    {
        private Queue<ICommand> commandQueue = new Queue<ICommand>();

        public void AddCommand(ICommand command)
        {
            commandQueue.Enqueue(command);
            Console.WriteLine("Enqueued");
        }
        public void ProcessCommands()
        {
            while (commandQueue.Count > 0)
            {
                var command = commandQueue.Dequeue();
                Console.WriteLine("Dequeued");
                command.Execute();
            }
        }
    }
}
