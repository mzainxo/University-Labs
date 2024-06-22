using System;

namespace sda_oel2_zain.Notifications
{
    public interface INotificationObserver
    {
        void Update(string message);
    }
    public class EmailNotification : INotificationObserver
    {
        public void Update(string message)
        {
            //implementation
            Console.WriteLine("Email sent");
        }
    }
    public class TextNotification : INotificationObserver
    {
        public void Update(string message)
        {
            // Implementation
            Console.WriteLine("Text message sent");
        }
    }
}