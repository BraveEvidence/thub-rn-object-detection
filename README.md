# react-native-rn-thub-objectdetection

Rn for object detection

## Installation

```sh
npm install react-native-rn-thub-objectdetection
```

## Usage

```js
import RnThubObjectdetection from 'react-native-rn-thub-objectdetection';

RnThubObjectdetection.objectDetection(
  imagePath,
  (data) => {
    setProgressBar(false);
    Alert.alert('', data.toString());
  },
  (errorMessage) => {
    setProgressBar(false);
    Alert.alert('', errorMessage);
  }
);
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
