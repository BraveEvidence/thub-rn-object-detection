import { NativeModules } from 'react-native';

type RnThubObjectdetectionType = {
  multiply(a: number, b: number): Promise<number>;
};

const { RnThubObjectdetection } = NativeModules;

export default RnThubObjectdetection as RnThubObjectdetectionType;
