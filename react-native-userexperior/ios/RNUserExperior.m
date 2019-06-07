
#import "RNUserExperior.h"
#import "UserExperior-Swift.h"
#import <objc/runtime.h>

@implementation RNUserExperior

@synthesize bridge = _bridge;

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

RCT_EXPORT_MODULE(UserExperior)

RCT_EXPORT_METHOD(startRecording: (NSString *) versionKey){
    dispatch_async(self.methodQueue, ^{
        [UserExperior initialize:versionKey];
    });
}

RCT_EXPORT_METHOD(setCustomTag: (NSString *) customTag customType: (NSString *) customType){
    dispatch_async(self.methodQueue, ^{
        [UserExperior setCustomTag:customTag customType:customType];
    });
}

RCT_EXPORT_METHOD(setUserIdentifier: (NSString *) userIdentifier){
    dispatch_async(self.methodQueue, ^{
        [UserExperior setUserIdentifier:userIdentifier];
    });
}

RCT_EXPORT_METHOD(resumeRecording){
    [UserExperior resumeRecording];
}
 
RCT_EXPORT_METHOD(pauseRecording){
    [UserExperior pauseRecording];
}

RCT_EXPORT_METHOD(stopRecording){
    [UserExperior stopRecording];
}

RCT_EXPORT_METHOD(markViewAsSensitive: (nonnull NSNumber *) tag) {
    dispatch_async(dispatch_get_main_queue(), ^{
        UIView* view = [self.bridge.uiManager viewForReactTag:tag];
        [UserExperior markViewAsSensitive:view];
    });
}

RCT_EXPORT_METHOD(unmarkViewAsSensitive: (nonnull NSNumber *) tag) {
    dispatch_async(dispatch_get_main_queue(), ^{
        UIView* view = [self.bridge.uiManager viewForReactTag:tag];
        [UserExperior unmarkViewAsSensitive:view];
    });
}


@end
  
