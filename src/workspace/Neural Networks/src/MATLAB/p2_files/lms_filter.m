[x,fs] = audioread('nsp3.wav'); % Input to the filter
% % % sound(x);
% [d,Fs] = audioread('fsp0.wav'); % Desired output
% mu = 0.2;
% lms = dsp.LMSFilter('Method','LMS','Length',32,'StepSize',mu,'LeakageFactor',0.1,'WeightsOutputPort',true);
% [y,e,w] = step(lms,x,d);
% y = y./(max(abs(y)));
% audiowrite('fsp3.wav',y,fs);
% soundsc(y);

% Use wpdencmp for signal compression. 
% Find default values (see ddencmp). 
[thr,sorh,keepapp,crit] = ddencmp('cmp','wp',x);

% De-noise signal using global thresholding with 
% threshold best basis. 
[xc,wpt,perf0,perfl2] = ... 
wpdencmp(x,sorh,3,'db2',crit,thr,keepapp);

soundsc(xc);