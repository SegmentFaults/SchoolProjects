import os
import time
import threading
import multiprocessing

NUM_WORKERS = 4

def only_sleep():
    print("PID: " + str(os.getpid()) + "Process name: " + multiprocessing.process.name + "Thread name " + threading.current_thread().name)
    time.sleep(1)

def compute():
    print("PID: " + os.getpid() + "Process name: " + multiprocessing.process.name + "Thread name " + threading.current_thread()._name)
    x = 0
    while x < 10000000:
        x=x+1

## Run tasks serially
start_time = time.time()
for _ in range(NUM_WORKERS):
    only_sleep()
end_time = time.time()
 
print("Serial time=", end_time - start_time)
 
# Run tasks using threads
start_time = time.time()
threads = [threading.Thread(target=only_sleep) for _ in range(NUM_WORKERS)]
[thread.start() for thread in threads]
[thread.join() for thread in threads]
end_time = time.time()
 
print("Threads time=", end_time - start_time)
 
# Run tasks using processes
start_time = time.time()
processes = [multiprocessing.Process(target=only_sleep()) for _ in range(NUM_WORKERS)]
[process.start() for process in processes]
[process.join() for process in processes]
end_time = time.time()
 
print("Parallel time=", end_time - start_time)