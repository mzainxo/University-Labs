using System;

namespace sda_oel2_zain.Notifications
{
    public class NotificationService
    {
        public NotificationService()
        {
            var Notifications = new Notification();
            var emailObserver = new EmailNotification();
            var textObserver = new TextNotification();

            Notifications.AttachObserver(emailObserver);
            Notifications.AttachObserver(textObserver);

            Notifications.Notify("New Item purchased");

            Notifications.DetachObserver(emailObserver);
            Notifications.DetachObserver(textObserver);
        }

    }
}
